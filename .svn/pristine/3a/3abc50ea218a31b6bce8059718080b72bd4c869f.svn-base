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
package com.llynx.modules.lo.ch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Class Name : IPLC01_Controller.java
 * @Description : 비밀번호 변경
 * @author USER
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
public class LOCH01_Controller {
	private static final Logger logger = LoggerFactory.getLogger(LOCH01_Controller.class);

	@Autowired LOCH01_Service loch01_Service;
	/**
	 * 
	 * @Method : iplc01
	 * @author USER
	 * @since 2021-04-16
	 * @Description : 
	 *   패스워드 변경 화면 호출
	 *
	 *  -------------------------------------------------
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/loch01.do")
	public ModelAndView loch01() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("패스워드 변경 화면 호출");	
		}
		
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("lo/ch/LOCH01");
                     
        return modelAndView;
	}
}
