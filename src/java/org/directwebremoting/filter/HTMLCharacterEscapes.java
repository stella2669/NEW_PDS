/*
 * Copyright 2019 LLYNX TECH All right reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.directwebremoting.filter;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.translate.AggregateTranslator;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;
import org.apache.commons.lang3.text.translate.EntityArrays;
import org.apache.commons.lang3.text.translate.LookupTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Class Name : XSSAjaxWrapper.java
 * @Description : XSSAjaxWrapper Class
 * @author USER
 * @since 2020-10-30
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-10-30  USER         최초생성
 *
 *</pre>
 */

public class HTMLCharacterEscapes extends CharacterEscapes {
	private static final Logger logger = LoggerFactory.getLogger(HTMLCharacterEscapes.class);
	
	private static final long serialVersionUID = 4616412490703140203L;

	public final int[] asciiEscapes;
	public final CharSequenceTranslator translator;
	
	public HTMLCharacterEscapes() {
		asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
		asciiEscapes['&'] = CharacterEscapes.ESCAPE_CUSTOM;
		asciiEscapes['#'] = CharacterEscapes.ESCAPE_CUSTOM;
		asciiEscapes['<'] = CharacterEscapes.ESCAPE_CUSTOM;
		asciiEscapes['>'] = CharacterEscapes.ESCAPE_CUSTOM;
//		asciiEscapes['('] = CharacterEscapes.ESCAPE_CUSTOM;
//		asciiEscapes[')'] = CharacterEscapes.ESCAPE_CUSTOM;
		asciiEscapes['\"'] = CharacterEscapes.ESCAPE_CUSTOM;
		asciiEscapes['\''] = CharacterEscapes.ESCAPE_CUSTOM;
		
		translator = new AggregateTranslator(
				new LookupTranslator(EntityArrays.BASIC_ESCAPE()) // <, >, &, " 포함
				, new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE())
				, new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE())
				, new LookupTranslator(
					new String[][] {
//				        {"(", "&#40;"},
//				        {")", "&#41;"},						
						{"\'", "&#39;"},
						{"#", "&#35;"}
					}	
				)
			);
	}
	
	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.core.io.CharacterEscapes#getEscapeCodesForAscii()
	 */
	@Override
	public int[] getEscapeCodesForAscii() {
		return asciiEscapes;
	}

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.core.io.CharacterEscapes#getEscapeSequence(int)
	 */
	@Override
	public SerializableString getEscapeSequence(int ch) {
//		if (logger.isInfoEnabled()) {
//			logger.info("{}", Character.toString((char)ch));
//		}
		
		return new SerializedString(translator.translate(Character.toString((char)ch)));
//		return new SerializedString(StringEscapeUtils.escapeHtml4(Character.toString((char)ch))); // 커스텀이 필요없을 경우 사용
	}
}
