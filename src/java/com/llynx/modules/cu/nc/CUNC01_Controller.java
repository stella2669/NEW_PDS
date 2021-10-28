package com.llynx.modules.cu.nc;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cu")
public class CUNC01_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(CUNC01_Controller.class);
		
	@RequestMapping("/cunc00.do")
	public ModelAndView cunc00() throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("DNC관리 페이지 호출");
		}
		mav.setViewName("cu/nc/CUNC00");
		return mav;
	}
	
	@RequestMapping("/cunc01.do")
	public ModelAndView cunc01() throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("DNC리스트 관리 페이지 호출");
		}
		mav.setViewName("cu/nc/CUNC01");
		return mav;
	}
	
	@RequestMapping("/cunc0101.do")
	public ModelAndView cunc0101(@RequestParam String dnclistId) throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("DNC리스트 데이터소스 관리 페이지 호출");
		}
		mav.addObject("dnclistId", dnclistId);
		mav.setViewName("cu/nc/CUNC0101");
		return mav;
	}
	
	@RequestMapping("/cunc0102.do")
	public ModelAndView cunc0102(@RequestParam Map<String, Object> param) throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("DNC리스트 데이터소스 등록 페이지 호출");
		}
		String thisPage = "데이터소스 등록";
		if(param.get("datasourceId")!=null) {
			mav.addObject("datasourceId", param.get("datasourceId").toString());
			thisPage = "데이터소스 상세정보";
		}
		mav.addObject("thisPage", thisPage);
		mav.setViewName("cu/nc/CUNC0102");
		return mav;
	}
	
	@RequestMapping("/cunc02.do")
	public ModelAndView cunc02() throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("DNC그룹 관리 페이지 호출");
		}
		mav.setViewName("cu/nc/CUNC02");
		return mav;
	}
	
	@RequestMapping("/cunc0201.do")
	public ModelAndView cunc0201(@RequestParam String dncGroupId) throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("DNC그룹 DNC리스트 할당 페이지 호출");
		}
		mav.addObject("dncGroupId", dncGroupId);
		mav.setViewName("cu/nc/CUNC0201");
		return mav;
	}
}
