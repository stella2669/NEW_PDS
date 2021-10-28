package com.llynx.modules.sy.ca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.modules.common.Common_Service;

@Controller
@RequestMapping("/sy")
public class SYCA01_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(SYCA01_Controller.class);
	
	@Autowired
	private Common_Service commonService;
	
	@RequestMapping("/syca01.do")
	public ModelAndView syca01() throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("완료코드 관리페이지 호출");
		}
		mav.setViewName("sy/ca/SYCA01");
		return mav;
	}
}
