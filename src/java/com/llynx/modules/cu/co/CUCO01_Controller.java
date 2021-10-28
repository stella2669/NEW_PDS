package com.llynx.modules.cu.co;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.cmn.auth.AccessDeninedException;
import com.llynx.modules.common.Common_Service;
import com.llynx.modules.cu.at.CUAT01_Service;

@Controller
@RequestMapping("/cu")
public class CUCO01_Controller {

	private static final Logger logger = LoggerFactory.getLogger(CUCO01_Controller.class);

	@Autowired
	private Common_Service commonService;

	@Autowired
	private CUAT01_Service cuat01Service;

	@RequestMapping("/cuco01.do")
	public ModelAndView cuco01() throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("컨택리스트 관리페이지 호출");
		}
		mav.setViewName("cu/co/CUCO01");
		return mav;
	}


	@RequestMapping("/cuco0101.do")
	public ModelAndView cuco0101(@RequestParam Map<String,Object> param) throws Exception, AccessDeninedException{
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("컨택리스트 상세페이지 호출");
		}
		String thisPage = "컨택리스트 등록";
		if(param.get("contactlistId")!=null) {
			mav.addObject("contactlistId", param.get("contactlistId").toString());
			thisPage = "컨택리스트 상세정보";
		}
		mav.addObject("attrList", cuat01Service.getAttrListY());
		mav.addObject("thisPage", thisPage);
		mav.setViewName("cu/co/CUCO0101");
		return mav;
	}

	@RequestMapping("/cuco02.do")
	public ModelAndView cuco02(@RequestParam String contactListId) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("컨택리스트 파일업로드 팝업창 호출");
		}
		mav.addObject("contactListId", contactListId);
		mav.setViewName("cu/co/CUCO02");
		return mav;
	}

	@ResponseBody
	@RequestMapping("/cuco02f.do")
	public Map<String, Object> cuco02f(@RequestParam String addURL, @RequestParam MultipartFile attachedFile) throws Exception {
		Map<String,Object> result = new HashMap<String, Object>();
		try {
			//result = ecmService.uploadFileAPI(addURL, attachedFile);
			result.put("result", "S");
	} catch (Exception e) {
			result.put("result", "F");
			logger.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping("/cuco03.do")
	public ModelAndView cuco03(@RequestParam String contactListId) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("컨택리스트 일괄상태변경 팝업창 호출");
		}
		mav.addObject("contactListId", contactListId);
		mav.setViewName("cu/co/CUCO03");
		return mav;
	}

	@RequestMapping("/cuco04.do")
	public ModelAndView cuco04(@RequestParam String contactListId) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("컨택리스트 데이터소스 관리 팝업창 호출");
		}
		mav.addObject("contactListId", contactListId);
		mav.setViewName("cu/co/CUCO04");
		return mav;
	}

	@RequestMapping("/cuco0401.do")
	public ModelAndView cuco0401(@RequestParam Map<String,Object> param) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("컨택리스트 데이터소스 추가 팝업창 호출");
		}
		String thisPage = "데이터소스 등록";
		if(param.get("datasourceId")!=null) {
			mav.addObject("datasourceId", param.get("datasourceId").toString());
			thisPage = "데이터소스 상세정보";
		}
		mav.addObject("thisPage", thisPage);
		System.out.println(param);
		mav.addObject("contactListId", param.get("contactListId").toString());
		mav.setViewName("cu/co/CUCO0401");
		return mav;
	}

	@RequestMapping("/cuco0402.do")
	public ModelAndView cuco0402(@RequestParam Map<String,Object> param) throws Exception, AccessDeninedException {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("컨택리스트 데이터소스 추가 팝업창 호출");
		}
		//mav.addObject("attrList", ecmService.getAPI("attributes", "{\"currentPage\":1, \"pageSize\":10000}").get("contents"));
		mav.addObject("tempOpList", commonService.getComCdList("TO000"));
		System.out.println(param);
		mav.addObject("contactListId", param.get("contactListId").toString());
		mav.setViewName("cu/co/CUCO0402");
		return mav;
	}

	@RequestMapping("/cuco05.do")
	public ModelAndView cuco05(@RequestParam String contactListId, @RequestParam String attrListId) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(logger.isDebugEnabled()) {
			logger.debug("컨택리스트 특성연결 팝업창 호출");
		}
		mav.addObject("contactListId", contactListId);
		mav.addObject("attrListId", attrListId);
		mav.setViewName("cu/co/CUCO05");
		return mav;
	}
}
