package com.llynx.modules.lo.ou;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/lo")
public class LOOU01_Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(LOOU01_Controller.class);
	
	@Autowired
	private LOOU01_Service loou01Service;
	
	/**
	 * 로그아웃 요청 처리
	 * @Method : logout
	 * @author USER
	 * @since 2021-04-16
	 * @Description : 
	 *
	 *  -------------------------------------------------
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@RequestMapping("/loou01.do")
	public void logout(HttpServletResponse response) throws Exception { //throws LogoutException {
		if (logger.isDebugEnabled()) {
			logger.debug("로그아웃 요청");
		}
		loou01Service.logout("");
	}
	
}
