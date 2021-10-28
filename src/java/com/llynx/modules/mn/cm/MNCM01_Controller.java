package com.llynx.modules.mn.cm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.modules.cu.nc.CUNC01_Controller;

@Controller
@RequestMapping("/mn")
public class MNCM01_Controller {
	private static final Logger logger = LoggerFactory.getLogger(CUNC01_Controller.class);
	@RequestMapping("/mncm01.do")
	public ModelAndView mncm01() throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("캠페인 모니터링 호출");
		}
		mav.setViewName("mn/cm/MNCM01");
		return mav;
	}
}
