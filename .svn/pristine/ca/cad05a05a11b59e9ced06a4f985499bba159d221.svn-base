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
package com.llynx.modules.sy.pg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.modules.common.Common_Service;


/**
 * @Class Name : SYPRO01_Controller.java
 * @Description : SYPRO01_Controller Class
 * @author ybLee
 * @since 2021-01-20
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021-01-20  ybLee     최초생성
 *
 *</pre>
 */
@RequestMapping(value="/sy")
@Controller
public class SYPG01_Controller {
	private static final Logger logger = LoggerFactory.getLogger(SYPG01_Controller.class);

	@Autowired
	private SYPG01_Service sypg01_Service;

	@Autowired
	private Common_Service common_Service;

 	/**
 	 * 프로그램관리
 	 *
 	 * @Method : syspro01
 	 * @author ybLee
 	 * @since 2021-01-20
 	 * @Description :
 	 *  -------------------------------------------------
 	 * @return
 	 * @throws Exception
 	 */

	@RequestMapping(value="/sypg01.do")
	public ModelAndView syspro01(@RequestParam HashMap<String, Object> paramMap) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("프로그램코드 관리 페이지 호출");
		}
		List<Map<String, Object>> MenuCodeList = sypg01_Service.getMenuCodeList();
		modelAndView.addObject("MenuCodeList", MenuCodeList);
		modelAndView.setViewName("sy/pg/SYPG01");
		return modelAndView;
	}

}
