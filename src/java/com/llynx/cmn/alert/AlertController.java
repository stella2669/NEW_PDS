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
package com.llynx.cmn.alert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Class Name : AlertController.java
 * @Description : AlertController Class
 * @author whale
 * @since 2020-12-06
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-12-06  whale         최초생성
 *
 *</pre>
 */
@Controller
public class AlertController {

	@RequestMapping("/common/alert.do")
	public ModelAndView llynxAlert() throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/common/LLYNX_Alert");
		return mav;
	}

	@RequestMapping("/common/confirm.do")
	public ModelAndView llynxConfirm() throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/common/LLYNX_Confirm");
		return mav;
	}
}
