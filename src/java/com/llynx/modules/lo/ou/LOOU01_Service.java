package com.llynx.modules.lo.ou;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.llynx.cmn.services.login.LoginService;
import com.llynx.modules.lo.in.LOIN01_Mapper;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@RemoteProxy(name="LOOU01_Service")
public class LOOU01_Service extends EgovAbstractServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(LOOU01_Service.class);
	
	@Autowired
	private LoginService session;
	@Autowired
	private LOOU01_Mapper loou01_Mapper;
	/**
	 * 로그아웃 요청 처리
	 * @Method : logout
	 * @author USER
	 * @since 2021-04-16
	 * @Description : 
	 *
	 *  -------------------------------------------------
	 *
	 * @param param
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RemoteMethod
	public void logout(String action) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("로그아웃 요청 유형 : {}", action);
		}
		
		String user = session.getUserId();
		if (user==null) {
			logger.error("logout user session is null");
		} else {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("empNo", session.getUserId());	
			                   	   
			                        
			  loou01_Mapper.updateLogoutInfo(param);
		}
		
	    HttpServletRequest request = null;
   		if (RequestContextHolder.getRequestAttributes() != null) {
   			request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();;
   		} else {
   			WebContext ctx = WebContextFactory.get();
			request = ctx.getHttpServletRequest();
   		}

        request.getSession().invalidate();
    }
}
