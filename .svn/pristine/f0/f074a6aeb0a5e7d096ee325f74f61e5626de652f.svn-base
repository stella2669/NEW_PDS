package com.llynx.modules.fr.ma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fr")
public class FRMA01_Controller {

	private static final Logger logger = LoggerFactory.getLogger(FRMA01_Controller.class);
	
	@RequestMapping("/frma01.do")
	public ModelAndView frma01() throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("인트로페이지 호출");
		}
		mav.setViewName("fr/ma/FRMA01");
		return mav;
	}
}
