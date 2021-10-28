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
package com.llynx.modules.lo.in;

import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Class Name : IPLA01_Controller.java
 * @Description : 로그인
 * @author ybLee
 * @since 2021-04-16
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021-04-16  ybLee         최초생성
 *
 *</pre>
 */
@Controller
@RequestMapping(value="/lo")
public class LOIN01_Controller {
	private static final Logger logger = LoggerFactory.getLogger(LOIN01_Controller.class);
	
	@Autowired
	LOIN01_Service loin01Service;

	@Resource(name="appProp")
	private Properties prop;
	
	/**
	 * 
	 * @Method : ipla01
	 * @author USER
	 * @since 2021-04-16
	 * @Description : 
	 *   로그인 페이지 호출 
	 *
	 *  -------------------------------------------------
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/loin01.do")
	public ModelAndView loin01() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("로그인 페이지 호출");
		}
		sessionClear();
		
		ModelAndView modelAndView = new ModelAndView();
                     modelAndView.setViewName("lo/in/LOIN01");
	
        return modelAndView;
	}
	
	public void sessionClear() {	
		HttpServletRequest request = null;
   		if (RequestContextHolder.getRequestAttributes() != null) {
   			request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
   		} else {
   			WebContext ctx = WebContextFactory.get();
			request = ctx.getHttpServletRequest();
   		}
   		
        request.getSession().invalidate();	
	}
}
