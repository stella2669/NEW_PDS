package com.llynx.modules.us.sm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.modules.common.Common_Service;

@RequestMapping(value="/us")
@Controller
public class USSM01_Controller {

	private static final Logger logger = LoggerFactory.getLogger(USSM01_Controller.class);
	
	@Autowired
	private Common_Service commonService;
	
	@RequestMapping("/ussm00.do")
	public ModelAndView ussm00() throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("스킬관리페이지 호출");
		}
		mav.setViewName("us/sm/USSM00");
		return mav;
	}
	
	@RequestMapping("/ussm01.do")
	public ModelAndView ussm01() throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("스킬관리페이지 호출");
		}
		mav.addObject("skillTypeList", commonService.getComCdList("SK000"));
		mav.setViewName("us/sm/USSM01");
		return mav;
	}
}
