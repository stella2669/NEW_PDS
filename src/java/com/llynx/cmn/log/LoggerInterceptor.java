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
package com.llynx.cmn.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView; 
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @Class Name : LoggerInterceptor.java
 * @Description : LoggerInterceptor Class
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
public class LoggerInterceptor extends HandlerInterceptorAdapter {
	protected Log logger = LogFactory.getLog(LoggerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if (logger.isInfoEnabled()) {
			logger.info("======================================\t "+request.getRequestURI()+" INFO \t======================================");
			logger.info("HOST :\t" +request.getRemoteHost());
		}
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("======================================\t "+request.getRequestURI()+" INFO \t======================================");
		}
	}
}