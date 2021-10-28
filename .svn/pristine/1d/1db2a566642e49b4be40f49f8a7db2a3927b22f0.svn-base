package com.llynx.modules.cu.at;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.cmn.auth.AccessDeninedException;

import com.llynx.modules.common.Common_Service;

@Controller
@RequestMapping("/cu")
public class CUAT01_Controller {

	private static final Logger logger = LoggerFactory.getLogger(CUAT01_Controller.class);

	@Autowired
	private Common_Service commonService;



	@RequestMapping("/cuat01.do")
	public ModelAndView cuat01() throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("특성관리페이지 호출");
		}
		//mav.addObject("typeList", commonService.getComCdList("DT000"));
		mav.addObject("typeAttr", commonService.getComCdList("CUA00"));
		mav.setViewName("cu/at/CUAT01");
		return mav;
	}

	@RequestMapping("/cuat03.do")
	public ModelAndView cuat03() throws Exception, AccessDeninedException {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("CSV템플릿 특성선택 팝업");
		}
		//mav.addObject("contactlistList", ecmService.getAPI("contactlists", "{\"currentPage\":1, \"pageSize\":1000}").get("contents"));
		mav.setViewName("cu/at/CUAT03");
		return mav;
	}

	@RequestMapping(value="/cuat03d.do")
	public void fileDown(@RequestParam String addURL, HttpServletResponse response) throws IOException, AccessDeninedException{
		//ecmService.getAPIFileDownload(addURL, response);
	}
}
