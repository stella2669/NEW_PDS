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
package com.llynx.cmn.map;

import java.util.HashMap;
import org.springframework.jdbc.support.JdbcUtils;


/**
 * @Class Name : CamelMap.java
 * @Description : CamelMap Class
 * @author USER
 * @since 2020-08-24
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-08-24  USER         최초생성
 *
 *</pre>
 */
public class CamelCaseMap extends HashMap<Object, Object> {
	private static final long serialVersionUID = -3539280844438299645L;
    
	@Override
	public Object put(Object k, Object v) {
	
		return super.put(JdbcUtils.convertUnderscoreNameToPropertyName((String) k), v);
	}}
