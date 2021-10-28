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
package com.llynx.cmn.filter;

import java.util.regex.Pattern; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Class Name : XSSRequestWrapper.java
 * @Description : XSSRequestWrapper Class
 * @author user
 * @since 2020-07-28
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-07-28  user         최초생성
 *
 *</pre>
 */
public class XSSRequestWrapper extends HttpServletRequestWrapper {
	private static final Logger logger = LoggerFactory.getLogger(XSSRequestWrapper.class);

	private static Pattern[] patterns = new Pattern[] {
			Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
			Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL),
			Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
							| Pattern.DOTALL),
			Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
			Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL),
			Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
			Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
			Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE
					| Pattern.MULTILINE | Pattern.DOTALL)

	};

	public XSSRequestWrapper(HttpServletRequest servletRequest) {

		super(servletRequest);

	}

	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);

		if (values == null) {
			return null;
		}

		int count = values.length;
		String[] encodedValues = new String[count];

		for (int i = 0; i < count; i++) {
			encodedValues[i] = stripXSS(values[i]);
		}

		return encodedValues;
	}

	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		
		return stripXSS(value);
	}

	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);

		return stripXSS(value);
	}

	private String stripXSS(String value) {		
		if (value != null) {
			value = value.replaceAll("\0", "");

			for (Pattern scriptPattern : patterns) {
				if ( scriptPattern.matcher(value).find() ) {
					value=value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
					value=value.replaceAll("&", "&#38;").replaceAll("#", "&#35;");
					value=value.replaceAll("(", "&#40;").replaceAll(")", "&41;");
					value=value.replaceAll("\'", "&#39;").replaceAll("\"", "&#34;");
				}
			}
		}

		if (logger.isTraceEnabled()) {
			logger.trace("xss filter --> {}", value);
		}
		
		return value;
	}

}