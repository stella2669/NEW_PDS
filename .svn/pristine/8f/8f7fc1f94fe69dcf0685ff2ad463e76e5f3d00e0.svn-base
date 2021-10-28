package com.llynx.modules.us.su;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value="/us")
@Controller
public class USSU01_Controller {

	private static final Logger logger = LoggerFactory.getLogger(USSU01_Controller.class);
	
	@Autowired
	private USSU01_Service ussu01_Service;
	
	@RequestMapping("/ussu01.do")
	public ModelAndView ussu01() throws Exception{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("스킬별 사용자관리 페이지 호출");
		}
		List<Map<String,Object>>skillTypeList = ussu01_Service.getSkillTypeList();
		
		mav.addObject("skillTypeList", skillTypeList);
		mav.setViewName("us/su/USSU01");
		return mav;
	}
}
