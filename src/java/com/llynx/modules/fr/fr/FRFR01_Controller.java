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
package com.llynx.modules.fr.fr;


import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @Class Name : frfr01_Controller.java
 * @Description : frfr01_Controller Class
 * @author ybLee
 * @since 2021-01-19
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021-01-19  ybLee         최초생성
 *
 *</pre>
 */
@Controller
@RequestMapping("/fr")
public class FRFR01_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(FRFR01_Controller.class);

	/**
	 * 
	 * @Method : lolog01
	 * @author ybLee
	 * @since 2021-01-19
	 * @Description : 
	 *  메인화면 로드
	 *
	 *  -------------------------------------------------
	 *
	 * @param 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/frfr01.do")
	@CrossOrigin(origins="*", allowedHeaders="*")
	public ModelAndView frfr01() {
		if (logger.isDebugEnabled()) {
			logger.debug("메인화면 호출");
		}
		
		HttpServletRequest request = null;
		if (RequestContextHolder.getRequestAttributes() != null) {
			request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		} else {
			WebContext ctx = WebContextFactory.get();
			request = ctx.getHttpServletRequest();
		}  

		ModelAndView modelAndView = new ModelAndView();
		if(request.getSession(false).getAttribute("PDS_USER_INFO") == null) {
			modelAndView.setViewName("lo/in/LOIN01");
		} else {
             modelAndView.setViewName("fr/fr/FRFR01_00");
		}     
		
		return modelAndView;
	}
	
	
}
