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
package com.llynx.cmn.resolver;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.llynx.cmn.map.CommandMap;
import com.llynx.cmn.util.DateTimeUtil;

/**
 * @Class Name : CustomMapArgumentResolver.java
 * @Description : CustomMapArgumentResolver Class
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
public class CustomMapArgumentResolver implements HandlerMethodArgumentResolver{
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		
		return CommandMap.class.isAssignableFrom(parameter.getParameterType());
	} 

	@SuppressWarnings("unchecked")
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		CommandMap commandMap = new CommandMap();
		
		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		Enumeration<?> enumeration = request.getParameterNames();
		String key = null;
		String[] values = null; 
		while(enumeration.hasMoreElements()){
			key = (String) enumeration.nextElement(); 
			values = request.getParameterValues(key);
			if(values != null){
				commandMap.put(key, (values.length > 1) ? values:values[0] );
				//System.out.println(key+"---:"+values[0]);
			}
		}
		//시간 설정
		commandMap.put("CRT_DATE",DateTimeUtil.getDate("yyyyMMddHHmmss"));
		//시간 설정
		commandMap.put("UPT_DATE",DateTimeUtil.getDate("yyyyMMddHHmmss"));
		
		//IP 설정
		commandMap.put("COM_IP",request.getRemoteAddr());
		
		HttpSession usersession=request.getSession();
		Map<String,Object> usermap=new HashMap<String,Object>();
		usermap=(Map<String,Object>)usersession.getAttribute("USERSESSION");
		
		if(usermap!=null) {
			commandMap.put("CRT_EMP_NO",usermap.get("EMP_NO"));
			commandMap.put("UPT_EMP_NO",usermap.get("EMP_NO"));
		}
		return commandMap;
	}  

}
