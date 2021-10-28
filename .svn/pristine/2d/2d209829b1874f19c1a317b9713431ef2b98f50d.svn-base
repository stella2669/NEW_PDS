package com.llynx.modules.ca.ca;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.modules.common.Common_Service;

@Controller
@RequestMapping("/ca")
public class CACA01_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(CACA01_Controller.class);
	
	@Autowired
	private Common_Service commonService;
	
	@RequestMapping("/caca01.do")
	public ModelAndView caca01() throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("콜백관리페이지 호출");
		}
		mav.addObject("CB100", commonService.getComCdList("CB100"));  //콜백상태
		mav.setViewName("ca/ca/CACA01");
		return mav;
	}
	
	@RequestMapping("/caca02.do")
	public ModelAndView caca02(@RequestParam HashMap<String, Object> paramMap) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("콜백관리페이지 호출");
		}
		mav.addObject("paramMap", paramMap);		
		//mav.addObject("CB100", commonService.getComCdList("CB100"));  //콜백상태
		mav.setViewName("ca/ca/CACA02");
		return mav;
	}
	
	@RequestMapping("/caca03.do")
	public ModelAndView caca03(@RequestParam HashMap<String, Object> paramMap) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("콜백관리페이지 호출");
		}
		mav.addObject("paramMap", paramMap);		
		mav.addObject("CB100", commonService.getComCdList("CB100"));  //콜백상태
		mav.setViewName("ca/ca/CACA03");
		return mav;
	}
	
	@RequestMapping("/caca04.do")
	public ModelAndView caca04(@RequestParam HashMap<String, Object> paramMap) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("콜백관리페이지 호출");
		}
		mav.addObject("paramMap", paramMap);		
		mav.addObject("CB100", commonService.getComCdList("CB100"));  //콜백상태
		mav.setViewName("ca/ca/CACA04");
		return mav;
	}
	
	@RequestMapping("/caca05.do")
	public ModelAndView caca05(@RequestParam HashMap<String, Object> paramMap) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("콜백관리페이지 호출");
		}
		mav.addObject("paramMap", paramMap);		
		mav.addObject("CB100", commonService.getComCdList("CB100"));  //콜백상태
		mav.setViewName("ca/ca/CACA05");
		return mav;
	}
	
	@RequestMapping("/caca06.do")
	public ModelAndView caca06(@RequestParam HashMap<String, Object> paramMap) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("콜백관리페이지 호출");
		}
		mav.addObject("paramMap", paramMap);		
		mav.addObject("CB100", commonService.getComCdList("CB100"));  //콜백상태
		mav.setViewName("ca/ca/CACA06");
		return mav;
	}
	@RequestMapping("/caca07.do")
	public ModelAndView caca07(@RequestParam HashMap<String, Object> paramMap) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("콜백관리페이지 호출");
		}
		mav.addObject("paramMap", paramMap);		
		mav.addObject("CB100", commonService.getComCdList("CB100"));  //콜백상태
		mav.setViewName("ca/ca/CACA07");
		return mav;
	}
}
