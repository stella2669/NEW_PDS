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
package com.llynx.cmn.execption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Class Name : CommonExceptionAdvice.java
 * @Description : CommonExceptionAdvice Class
 * @author USER
 * @since 2020-10-21
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-10-21  USER         최초생성
 *
 *</pre>
 */
@ControllerAdvice
public class CommonExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

	@ExceptionHandler(Exception.class)
	public ModelAndView exception(HttpServletRequest request, HttpServletResponse reponse, Model model, Exception e) {
		logger.error("Exception catch {}", e.getMessage());

		ModelAndView modelAndView = new ModelAndView();
			         modelAndView.setViewName("common/error_biz");
			         e.getStackTrace();
			         modelAndView.addObject("message", e.getMessage());

		return modelAndView;
	}
}
