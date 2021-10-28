package com.llynx.modules.us.hi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value="/us")
@Controller
public class USHI01_Controller {
private static final Logger logger = LoggerFactory.getLogger(USHI01_Controller.class);

	@RequestMapping(value="/ushi01.do")
	public ModelAndView usum01() throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("사용자 로그인/아웃 호출");
		}

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("us/hi/USHI01");
		return modelAndView;
	}
}
