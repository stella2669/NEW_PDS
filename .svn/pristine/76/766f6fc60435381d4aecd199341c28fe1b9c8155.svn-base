package com.llynx.modules.cp.sc;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.cmn.auth.AccessDeninedException;

import com.llynx.modules.common.Common_Service;

@Controller
@RequestMapping("/cp")
public class CPSC01_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(CPSC01_Controller.class);
	
	@Autowired
	private Common_Service commonService;
	
	
	@RequestMapping("/cpsc01.do")
	public ModelAndView cpsc01() throws Exception, AccessDeninedException {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("일정 관리페이지 호출");
		}
		Map<String,Object> jsonBody = new HashMap<String,Object>();
		jsonBody.put("currentPage", 1);
		jsonBody.put("pageSize", 1000);
		mav.addObject("typeList", commonService.getComCdList("CL000"));
		mav.addObject("frequencyList", commonService.getComCdList("RF000"));
		//mav.addObject("campList", ecmService.getAPI("campaigns", ECMService.mapToJson(jsonBody)).get("contents"));
		mav.setViewName("cp/sc/CPSC01");
		return mav;
	}
	
	@RequestMapping("/cpsc02.do")
	public ModelAndView cpsc02() throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("일정등록 팝업창 호출");
		}
		mav.addObject("typeList", commonService.getComCdList("CL000"));
		mav.setViewName("cp/sc/CPSC02");
		return mav;
	}
}
