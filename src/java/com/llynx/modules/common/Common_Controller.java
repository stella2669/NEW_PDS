package com.llynx.modules.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/com")
public class Common_Controller {

	private static final Logger logger = LoggerFactory.getLogger(Common_Controller.class);
	
	@ResponseBody
	@RequestMapping("/excelDown.do")
	public ModelAndView excelDown(@RequestParam Map<String,Object> param) throws Exception{
		if(logger.isDebugEnabled()) {
			logger.debug("Excel file download.");
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("hiddenYn", param.get("hiddenYn").toString());
		mav.addObject("title", param.get("title").toString());
		mav.addObject("fileNm", param.get("fileNm").toString());

		ObjectMapper mapper = new ObjectMapper();
		
		String colModelData = param.get("colModel").toString();
		List<Map<String,Object>> colModel = mapper.readValue(colModelData, new TypeReference<List<Map<String,Object>>>(){});
		mav.addObject("colModel", colModel);
		
		String dataListData = param.get("dataList").toString();
		List<Map<String,Object>> dataList = mapper.readValue(dataListData, new TypeReference<List<Map<String,Object>>>(){});
		mav.addObject("dataList", dataList);
		
		
		mav.setViewName("common/excelForm");
		return mav;
	}
}
