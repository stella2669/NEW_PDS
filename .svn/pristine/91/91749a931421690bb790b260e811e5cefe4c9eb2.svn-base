package com.llynx.modules.cp.hm;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.modules.common.Common_Service;


@Controller
@RequestMapping("/cp")
public class CPHM01_Controller {

	private static final Logger logger = LoggerFactory.getLogger(CPHM01_Controller.class);

	@Autowired
	private Common_Service commonService;

	

	@RequestMapping("/cphm01.do")
	public ModelAndView cphm01() throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("휴일관리페이지 호출");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		mav.addObject("typeList", commonService.getComCdList("HD000"));
		mav.addObject("typeList2", commonService.getComCdList("HR000"));
		//mav.addObject("compCodeList", sycp01Service.getCompleteCodes(param).get("list"));
		mav.setViewName("cp/hm/CPHM01");
		return mav;
	}
}
