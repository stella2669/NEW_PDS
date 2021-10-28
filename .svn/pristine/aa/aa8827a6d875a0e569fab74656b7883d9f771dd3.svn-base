package com.llynx.modules.fr.me;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fr")
public class FRME01_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(FRME01_Controller.class);
	
	@RequestMapping("/frme02.do")
	public ModelAndView frme02() throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("마이메뉴관리 페이지 호출");
		}
		mav.setViewName("fr/me/FRME02");
		return mav;
	}
}
