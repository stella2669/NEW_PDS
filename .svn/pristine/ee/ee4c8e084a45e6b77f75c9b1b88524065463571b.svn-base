package com.llynx.modules.cp.cm;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.cmn.auth.AccessDeninedException;

import com.llynx.modules.common.Common_Service;

@Controller
@RequestMapping("/cp")
public class CPCM01_Controller {

	private static final Logger logger = LoggerFactory.getLogger(CPCM01_Controller.class);

	@Autowired
	private Common_Service commonService;



	@RequestMapping("/cpcm01.do")
	public ModelAndView cpcm01(@RequestParam Map<String,Object> param) throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("캠페인관리페이지 호출");
		}
		mav.setViewName("cp/cm/CPCM01");
		return mav;
	}

	@RequestMapping("/cpcm0101.do")
	public ModelAndView cpcm0101(@RequestParam Map<String,Object> param) throws Exception, AccessDeninedException{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("캠페인 상세페이지 호출");
		}
		String thisPage = "캠페인 등록";
		if(param.get("campId")!=null) {
			mav.addObject("campId", param.get("campId").toString());
			thisPage = "캠페인 상세정보";
		}
		mav.addObject("thisPage", thisPage);
		mav.addObject("campTypeList", commonService.getComCdList("CP000"));
		//mav.addObject("contactlistList", ecmSerivce.getAPI("contactlists", "{\"currentPage\":1, \"pageSize\":10000}").get("contents"));
		//mav.addObject("filterTemplateList", ecmSerivce.getAPI("filtertemplates", "{\"currentPage\":1, \"pageSize\":10000}").get("contents"));
		mav.setViewName("cp/cm/CPCM0101");
		return mav;
	}

	@RequestMapping("/cpcm02.do")
	public ModelAndView cpcm02(@RequestParam Map<String, Object> param) throws Exception, AccessDeninedException{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("컨택리스트선택 팝업창 호출");
		}
		if(param.get("campId")!=null) {
			mav.addObject("campId", param.get("campId").toString());
		}
		//mav.addObject("contactlistList", ecmSerivce.getAPI("contactlists", "{\"currentPage\":1, \"pageSize\":10000}").get("contents"));
		//mav.addObject("filterTemplateList", ecmSerivce.getAPI("filtertemplates", "{\"currentPage\":1, \"pageSize\":10000}").get("contents"));
		mav.setViewName("cp/cm/CPCM02");
		return mav;
	}

	@RequestMapping("/cpcm03.do")
	public ModelAndView cpcm03(@RequestParam String campId) throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("캠페인복제 팝업창 호출");
		}
		mav.addObject("campId", campId);
		mav.setViewName("cp/cm/CPCM03");
		return mav;
	}

	@RequestMapping("/cpcm04.do")
	public ModelAndView cpcm04(@RequestParam String campId) throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("캠페인 실행관리 팝업창 호출");
		}
		mav.addObject("campId", campId);
		mav.setViewName("cp/cm/CPCM04");
		return mav;
	}

	@RequestMapping("/cpcm05.do")
	public ModelAndView cpcm05(@RequestParam String campId) throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("캡페인 일정추가 팝업창 호출");
		}
		mav.addObject("campId", campId);
		mav.setViewName("cp/cm/CPCM05");
		return mav;
	}
}
