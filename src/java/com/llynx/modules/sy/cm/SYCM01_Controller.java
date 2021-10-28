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
package com.llynx.modules.sy.cm;

import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Class Name : SYCOM01_Controller.java
 * @Description : SYCOMSYCOM01_Controller01Controller Class
 * @author ybLee
 * @since 2020-08-31
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021-01-19  ybLee     최초생성
 *
 *</pre>
 */
@RequestMapping(value="/sy")
@Controller
public class SYCM01_Controller {
	private static final Logger logger = LoggerFactory.getLogger(SYCM01_Controller.class);

 	/**
 	 * 공통코드관리
 	 * 
 	 * @Method : aja000100m
 	 * @author LEEYR
 	 * @since 2020-09-01
 	 * @Description : 
 	 *  -------------------------------------------------
 	 * @return
 	 * @throws Exception
 	 */
	
	@RequestMapping(value="/sycm01.do")
	public ModelAndView syscom01(@RequestParam Map<String, Object> paramMap) throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("공통코드관리 페이지 호출");
		}
				
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sy/cm/SYCM01");
			
		return modelAndView;
		
		
	}
	
}
 