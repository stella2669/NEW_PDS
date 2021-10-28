package com.llynx.modules.mn.sm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mn")
public class MNSM01_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(MNSM01_Controller.class);
	
	@RequestMapping("/mnsm01.do")
	public ModelAndView mnsm01() throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("상담사 모니터링 호출");
		}
		mav.setViewName("mn/sm/MNSM01");
		return mav;
	}

}
