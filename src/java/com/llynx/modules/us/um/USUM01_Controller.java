package com.llynx.modules.us.um;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llynx.modules.common.Common_Service;

/**
 * @Class Name : USAGT01_Controller.java
 * @Description : USAGT01_Controller Class
 * @author ISKRA
 * @since 2020-09-15
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-09-15  ISKRA     최초생성
 *
 *</pre>
 */
@RequestMapping(value="/us")
@Controller
public class USUM01_Controller {
private static final Logger logger = LoggerFactory.getLogger(USUM01_Controller.class);
	
	@Autowired
	private Common_Service common_Service;	
	
	@RequestMapping(value="/usum01.do")
	public ModelAndView usum01() throws Exception {
		if(logger.isDebugEnabled()) {
			logger.debug("사용자관리 호출");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("groupCdList", common_Service.getGroupList());
		modelAndView.addObject("stCdList", common_Service.getComCdList("ST000"));  //근무상태
		modelAndView.addObject("auCdList", common_Service.getAuthList());  //권한코드
		modelAndView.addObject("roCdList", common_Service.getComCdList("WK000"));  //역할코드
		modelAndView.setViewName("us/um/USUM01");
		return modelAndView;
	}
}
