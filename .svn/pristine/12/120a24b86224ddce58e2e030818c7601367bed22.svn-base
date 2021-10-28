package com.llynx.modules.al.ca;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/al")
public class ALCA01_Controller {
	private static final Logger logger = LoggerFactory.getLogger(ALCA01_Controller.class);

	@Autowired
	private ALCA01_Service alca01Service;

	@RequestMapping("/alca01.do")
	public ModelAndView alca01(@RequestParam Map<String, Object> param) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("캠페인별 통계 호출");
		}
		mav.addObject("param", param);
		mav.addObject("campStaticsList", alca01Service.getCampStaticsData(param));
		mav.setViewName("al/ca/ALCA01");
		return mav;
	}

	@RequestMapping("/alca01ex.do")
	public ModelAndView alca01ex(@RequestParam Map<String, Object> param) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("캠페인별 통계 호출");
		}
		mav.addObject("param", param);
		mav.addObject("title", param.get("title").toString());
		mav.addObject("fileNm", param.get("fileNm").toString());
		mav.addObject("campStaticsList", alca01Service.getCampStaticsData(param));
		mav.setViewName("al/ca/ALCA01ex");
		return mav;
	}

}
