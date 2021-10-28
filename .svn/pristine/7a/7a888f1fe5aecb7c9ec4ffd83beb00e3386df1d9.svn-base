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

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.directwebremoting.AjaxFilter;
import org.directwebremoting.AjaxFilterChain;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Class Name : AjaxServerFilter.java
 * @Description : AjaxServerFilter Class
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
public class AjaxServerFilter implements AjaxFilter {
	private static final Logger logger = LoggerFactory.getLogger(AjaxServerFilter.class);
		
	/* (non-Javadoc)
	 * @see org.directwebremoting.AjaxFilter#doFilter(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], org.directwebremoting.AjaxFilterChain)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object doFilter(Object object, Method method, Object[] param, AjaxFilterChain chain) throws Exception {
		WebContext ctx = WebContextFactory.get();
		HttpServletRequest request = ctx.getHttpServletRequest();
		
		if (request != null && request.getContentType() != null && request.getContentType().indexOf("multipart/form-data") > -1) {
			if (logger.isInfoEnabled()) {
				logger.info("multipart/form-data request");
			}
			return chain.doFilter(object, method, param);
		}

		if (logger.isInfoEnabled()) {
			logger.info("read list : {}, param : {}", param.length, Arrays.toString(param));
		}
		
		if (!ObjectUtils.isEmpty(param)) {
			ObjectMapper objectMapper = new ObjectMapper();
			             objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                         objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());
                    
			int ParamSize = param.length;
			Object[] paramEscape = new Object[ParamSize];
		    			
			if (ParamSize == 1) { // 단일 건				
				if (param[0] instanceof Map) {
					paramEscape[0] = escapeMap(objectMapper, (Map<String, Object>) param[0]);					
				} else if (param[0] instanceof List) {
					paramEscape[0] = escapeList(objectMapper, (List<Map<String, Object>>) param[0]);					
				} else if (param[0] instanceof String[]) {
					paramEscape[0] = escapeListObject((String[]) param[0]);
				} else if (param[0] instanceof Integer || param[0] instanceof String) {
					paramEscape[0] = escapeObject(param[0]);				
				} else {
					logger.error("parameter check --> {}", param[0]);
				}				
			} else {				
				for (int i=0; i<ParamSize; i++) {
//					if (logger.isInfoEnabled()) {
//						logger.info("is List     --> {}, {}", i, param[i] instanceof List);
//						logger.info("is Map      --> {}, {}", i, param[i] instanceof Map);
//						logger.info("is String[] --> {}, {}", i, param[i] instanceof String[]);
//						logger.info("is Integer  --> {}, {}", i, param[i] instanceof Integer);
//						logger.info("is String   --> {}, {}", i, param[i] instanceof String);
//					}
					if (param[i] == null || ObjectUtils.isEmpty(param[i])) {
						// argument type mismatch 예외처리
						if (param[i] instanceof List) {
							paramEscape[i] = new ArrayList<Map<String, Object>>();		
						} else if (param[i] instanceof Map) {
							paramEscape[i] = new HashMap<String, Object>();		
						}			
					} else if (param[i] instanceof Map) {
						paramEscape[i] = escapeMap(objectMapper, (Map<String, Object>) param[i]);							
					} else if (param[i] instanceof List) {
						if (((List)param[i]).size() > 0) {
							Object o = ((List)param[i]).get(0);
							if (o instanceof String) {
								String[] temp = (String[]) escapeListObject(((List<String>) param[i]).toArray());
								paramEscape[i] = Arrays.asList(temp);
							} else if (o instanceof Integer) {
								Integer[] temp = (Integer[]) escapeListObject(((List<Integer>) param[i]).toArray());
								paramEscape[i] = Arrays.asList(temp);
							} else {
								paramEscape[i] = escapeList(objectMapper, (List<Map<String, Object>>) param[i]);
							}
						} else {
							paramEscape[i] = escapeList(objectMapper, (List<Map<String, Object>>) param[i]);
						}
					} else if (param[i] instanceof String[]) {
						paramEscape[i] = escapeListObject((String[]) param[i]);
					} else if (param[i] instanceof Integer || param[i] instanceof String) {
						//paramEscape[i] = escapeObject(param[i]);
						paramEscape[i] = param[i];
					} else {
						logger.error("parameter check --> {}", param[i]);
					}
				}
			}
			
//			TODO 오류가 발생되면 원본을 리턴하기 위해 예외처리
			if (!ObjectUtils.isEmpty(paramEscape)) {
				param = paramEscape;
				
				if (logger.isInfoEnabled()) {
					logger.info("escape : {}", Arrays.toString(param));
				}
			} else if (logger.isInfoEnabled()) {
				logger.info("escape parameter is null");
				for (int i=0; i<paramEscape.length; i++) {
					logger.info("{} - {}", i, paramEscape[i].toString());
				}
			}
			
			paramEscape = null;
			objectMapper = null;
		}	
		
		return chain.doFilter(object, method, param);
	}


	private List<Map<String, Object>> escapeList(ObjectMapper objectMapper, List<Map<String, Object>> listMap) {
		List<Map<String, Object>> paramListMap = null;
		try {
			String json = objectMapper.writeValueAsString(listMap);			
			paramListMap = objectMapper.readValue(json, new TypeReference<List<Map<String, Object>>>(){});
		} catch (JsonProcessingException jpe) {
			logger.error("", jpe);
		} catch (IOException ie) {
			logger.error("", ie);
		} catch (Exception e) {
			logger.error("", e);
		} 		
		return paramListMap;
	} 

	private Map<String, Object> escapeMap(ObjectMapper objectMapper, Map<String, Object> map) {		
		Map<String, Object> paramMap = null;
		try {
			String json = objectMapper.writeValueAsString(map);			
			paramMap = objectMapper.readValue(json, new TypeReference<Map<String, Object>>(){});
		} catch (JsonProcessingException jpe) {
			logger.error("", jpe);
		} catch (IOException ie) {
			logger.error("", ie);
		} catch (Exception e) {
			logger.error("", e);
		} 		
		return paramMap;
	}
	
	private Object escapeObject(Object obj) {
		return escep(obj);
	}

	private Object escapeListObject(Object[] obj) {
		if (obj[0] instanceof Integer) {
			Integer[] paramList = new Integer[obj.length];
			for (int i=0; i<obj.length; i++) {
				paramList[i] = (Integer) escep(obj[i]);
			}
			return paramList;
		} else {
			String[] paramList = new String[obj.length];
			for (int i=0; i<obj.length; i++) {
				paramList[i] = (String) escep(obj[i]);
			}
			return paramList;
		}
	}
	
	private Object escep(Object obj) {
		Object objrtn = null;
		String value = StringUtils.EMPTY;
		boolean bInt = false;
		
		if (obj instanceof Integer) {
			bInt = true;
			value = String.valueOf(obj);
		} else {
			value = StringUtils.defaultIfEmpty((String)obj, StringUtils.EMPTY);
		}
		
		if (value.isEmpty() || value == null) {
			return StringUtils.EMPTY;
		}
		
		StringBuffer strBuff = new StringBuffer();
		for (int i=0; i<value.length(); i++) {
			char c = value.charAt(i);
			switch (c) {
			case '<':
					strBuff.append("&lt;");
				break;
			case '>':
					strBuff.append("&gt;");
				break;
			case '"':
					strBuff.append("&quot;");
				break;
			case '\'':
					strBuff.append("&apos;");
				break;
			case '(':
					strBuff.append("&#40;");
				break;	
			case ')':
					strBuff.append("&#41;");
				break;	
			case '#':
					strBuff.append("&#35;");
				break;	
			case '&':
					strBuff.append("&amp;");
				break;	
			default:
					strBuff.append(c);
				break;
			}
		}
		
		if (bInt) {
			objrtn = Integer.parseInt(strBuff.toString());
		} else {
			objrtn = strBuff.toString();
		}
		bInt = false;
		
		return objrtn;
	}
}
