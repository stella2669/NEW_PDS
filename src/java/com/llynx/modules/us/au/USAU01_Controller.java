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
package com.llynx.modules.us.au;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.modules.common.Common_Service;


/**
 * @Class Name : AGC0001Controller.java
 * @Description : AGC0001Controller Class
 * @author LEEYR
 * @since 2020-09-15
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-09-15  LEEYR     최초생성
 *
 *</pre>
 */
@RequestMapping(value="/us")
@Controller
public class USAU01_Controller {
	private static final Logger logger = LoggerFactory.getLogger(USAU01_Controller.class);
	
	@Autowired
	private Common_Service common_Service;	
	
	@RequestMapping(value="/usau00.do")
	public ModelAndView usau00() throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("권한페이지 프레임 호출");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("us/au/USAU00");
		return modelAndView;
	}
	
	@RequestMapping(value="/usau01.do")
	public ModelAndView usau01() throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("권한페이지 호출");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("groupCdList", common_Service.getGroupList());
		modelAndView.addObject("progCdList", common_Service.getProgCdList());
		modelAndView.setViewName("us/au/USAU01");
		return modelAndView;
	}
	
	@RequestMapping(value="/usau02.do")
	public ModelAndView usau02() throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("권한페이지 호출");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("authCdList", common_Service.getAuthList());
		modelAndView.addObject("progCdList", common_Service.getProgCdList());
		modelAndView.setViewName("us/au/USAU02");
		return modelAndView;
	}
	
}
 