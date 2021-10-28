package com.llynx.modules.cp.em;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.modules.common.Common_Service;

@Controller
@RequestMapping("/cp")
public class CPEM01_Controller {

	private static final Logger logger = LoggerFactory.getLogger(CPEM01_Controller.class);

	@Autowired
	private Common_Service commonService;

	@RequestMapping("/cpem01.do")
	public ModelAndView cpem01(@RequestParam Map<String,Object> param) throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("캠페인관리페이지 호출");
		}
		mav.setViewName("cp/em/CPEM01");
		return mav;
	}
}
