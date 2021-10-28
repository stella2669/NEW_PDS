package com.llynx.modules.al.cc;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.cmn.auth.AccessDeninedException;


@Controller
@RequestMapping("/al")
public class ALCC01_Controller {
	private static final Logger logger = LoggerFactory.getLogger(ALCC01_Controller.class);

	@Autowired
	private ALCC01_Service alcc01Service;


	@RequestMapping("/alcc01.do")
	public ModelAndView alca01(@RequestParam Map<String, Object> param) throws Exception, AccessDeninedException {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("캠페인 완료코드별 통계 호출");
		}
		mav.addObject("param", param);
		//mav.addObject("completionCodeList", alac01Service.getCompCodeLists());
		mav.addObject("campList", alcc01Service.getCampListByDate(param));
		mav.addObject("campStaticsList", alcc01Service.getCampCompCodeStaticsData(param));
		mav.setViewName("al/cc/ALCC01");
		return mav;
	}

	@RequestMapping("/alcc01ex.do")
	public ModelAndView alca01ex(@RequestParam Map<String, Object> param) throws Exception, AccessDeninedException {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("캠페인 완료코드별 통계 호출");
		}
		mav.addObject("param", param);
		mav.addObject("title", param.get("title").toString());
		mav.addObject("fileNm", param.get("fileNm").toString());
		//mav.addObject("completionCodeList", alac01Service.getCompCodeLists());
		mav.addObject("campList", alcc01Service.getCampListByDate(param));
		mav.addObject("campStaticsList", alcc01Service.getCampCompCodeStaticsData(param));
		mav.setViewName("al/cc/ALCC01ex");
		return mav;
	}

}
