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
package com.llynx.cmn.config;

//import java.io.BufferedInputStream;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.net.InetAddress;
//import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.WebApplicationInitializer;

//import egovframework.com.cmm.EgovWebUtil;
//import egovframework.com.cmm.util.EgovResourceCloseHelper;


/**
 * @Class Name : LlynxWebApplicationInitializer.java
 * @Description : LlynxWebApplicationInitializer Class
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
public class LlynxWebApplicationInitializer implements WebApplicationInitializer {
	private static final Logger logger = LoggerFactory.getLogger(LlynxWebApplicationInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		if (logger.isDebugEnabled()) {
			logger.debug("welcome llynxtech");
		}
/*		
		if (logger.isDebugEnabled()) {
			logger.debug("WebApplicationInitializer START");
		}
			
		//-------------------------------------------------------------
		// Web ServletContextListener 설정
		//-------------------------------------------------------------
		servletContext.addListener(new com.llynx.cmn.context.WebServletContextListener());
		
		//-------------------------------------------------------------
		// Spring CharacterEncodingFilter 설정
		//-------------------------------------------------------------
		FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("encodingFilter", new org.springframework.web.filter.CharacterEncodingFilter());
		                           characterEncoding.setInitParameter("encoding", "UTF-8");
		                           characterEncoding.setInitParameter("forceEncoding", "true");
		                           characterEncoding.addMappingForUrlPatterns(null, false, "*.do");
		
		//-------------------------------------------------------------
		// Spring ServletContextListener 설정
		//-------------------------------------------------------------
		XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
		                         rootContext.setConfigLocations(new String[] { "classpath*:spring/context-*.xml" });
		                         rootContext.refresh();
		                         rootContext.start();
		
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		//-------------------------------------------------------------
		// Spring ServletContextListener 설정
		//-------------------------------------------------------------
		XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
		                         xmlWebApplicationContext.setConfigLocation("/WEB-INF/classes/egovframework/springmvc/egov-com-*.xml");
		                        //  xmlWebApplicationContext.setConfigLocation("/WEB-INF/config/egovframework/springmvc/egov-com-*.xml");
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(xmlWebApplicationContext));
		                            dispatcher.addMapping("/"); // Facebook OAuth 사용시 변경
		                            dispatcher.setLoadOnStartup(1);
		
		//-------------------------------------------------------------
		// EgovLoginPolicyFilter 설정
		//-------------------------------------------------------------	
		FilterRegistration.Dynamic egovLoginPolicyFilter = servletContext.addFilter("LoginPolicyFilter", new EgovLoginPolicyFilter());
		egovLoginPolicyFilter.addMappingForUrlPatterns(null, false, "/uat/uia/actionLogin.do");
				
		//-------------------------------------------------------------
		// HiddenHttpMethodFilter 설정 (Facebook OAuth 사용시 설정)
		//-------------------------------------------------------------
		FilterRegistration.Dynamic hiddenHttpMethodFilter = servletContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter());
		                           hiddenHttpMethodFilter.addMappingForUrlPatterns(null, false, "/*");
		
		//-------------------------------------------------------------
		// Tomcat의 경우 allowCasualMultipartParsing="true" 추가
		// <Context docBase="" path="/" reloadable="true" allowCasualMultipartParsing="true">
		//-------------------------------------------------------------
		MultipartFilter springMultipartFilter = new MultipartFilter();
		                springMultipartFilter.setMultipartResolverBeanName("multipartResolver");
		                
		FilterRegistration.Dynamic multipartFilter = servletContext.addFilter("springMultipartFilter", springMultipartFilter);
		                           multipartFilter.addMappingForUrlPatterns(null, false, "*.do");
		
		//-------------------------------------------------------------
	    // HTMLTagFilter의 경우는 파라미터에 대하여 XSS 오류 방지를 위한 변환을 처리합니다.
		//-------------------------------------------------------------	
	    // HTMLTagFIlter의 경우는 JSP의 <c:out /> 등을 사용하지 못하는 특수한 상황에서 사용하시면 됩니다.
	    // (<c:out />의 경우 뷰단에서 데이터 출력시 XSS 방지 처리가 됨)
		FilterRegistration.Dynamic htmlTagFilter = servletContext.addFilter("htmlTagFilter", new HTMLTagFilter());
		                           htmlTagFilter.addMappingForUrlPatterns(null, false, "*.do");
		
		//-------------------------------------------------------------
		// Spring RequestContextListener 설정
		//-------------------------------------------------------------
		servletContext.addListener(new org.springframework.web.context.request.RequestContextListener());
		
		if (logger.isDebugEnabled()) {
			logger.debug("WebApplicationInitializer END");
		}
		
*/
	}	
}
