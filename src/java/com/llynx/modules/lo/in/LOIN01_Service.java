/*
 * Copyright 2019 LLYNX TECH All right reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.llynx.modules.lo.in;

import java.net.SocketTimeoutException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.llynx.cmn.auth.AccessDeninedException;
import com.sun.mail.util.SocketConnectException;

import egovframework.com.cmm.SessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : IPLA01_Service.java
 * @Description : IPLA01_Service Class
 * @author ybLee
 * @since 2021-04-16
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021-04-16  ybLee         최초생성
 *
 *</pre>
 */
@RemoteProxy(name="LOIN01_Service")
public class LOIN01_Service extends EgovAbstractServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(LOIN01_Service.class);

	@Autowired
	private LOIN01_Mapper loin01Mapper;

	@Resource(name="appProp")
	private Properties prop;
	private SessionVO sessionVo = null;

	/**
	 * 로그인 요청 처리
	 * @Method : findUser
	 * @author ybLee
	 * @since 2021-01-19
	 * @Description :
	 *
	 *  -------------------------------------------------
	 *
	 * @param param
	 * @param session
	 * @return
	 */
	@RemoteMethod
	public Map<String, Object> findUser(HashMap<String, Object> param) throws SQLException, AccessDeninedException {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			sessionVo = loin01Mapper.findUser(param);

			if (sessionVo == null) { // 조회된 사용자가 없습니다.
				result.put("result", "F");
				result.put("message", "사용자 ID가 잘못되었습니다.\n다시 확인하시기 바랍니다.");
	    	} else {
	    		result = Validator(sessionVo, param);
	    	}
		} catch(SocketConnectException sce) {
			result.put("result", "F");
			result.put("message", "로그인 정보 조회중 오류가 발생하였습니다."+sce.getMessage());
			logger.error("로그인 정보 조회중 에러발생 : {}", sce.getMessage());
		} catch(SocketTimeoutException ste){
			result.put("result", "F");
			result.put("message", "로그인 정보 조회중 어류가 발생하였습니다."+ste.getMessage());
			logger.error("로그인 정보 조회중 에러발생 : {}", ste.getMessage());
		} catch (DataAccessException dae) {
			logger.error("", dae);
			result.put("result", "F");
			result.put("message", "로그인 정보 조회중 오류가 발생되었습니다.\n관리자에게 문의하세요.");
		} catch (Exception e) {
			logger.error("", e);

			result.put("result", "F");
			result.put("message", "로그인 정보 조회중 오류가 발생되었습니다.\n관리자에게 문의하세요.");
		}

		if ("S".equals(result.get("result"))) {
			HttpServletRequest session = null;
			if (RequestContextHolder.getRequestAttributes() != null) {
				session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			} else {
				WebContext ctx = WebContextFactory.get();
				session = ctx.getHttpServletRequest();
			}


			String addr = StringUtils.defaultString(session.getRemoteAddr(), StringUtils.EMPTY);
			if (addr != null) {
				sessionVo.setLoginIp(addr);
			}

			result.put("inf", setPropty(param));

//			 세션생성
			if (sessionVo != null ) {
				session.getSession(true).setAttribute(sessionVo.getUserId(), sessionVo); // 중복로그인 확인용
				session.getSession(true).setAttribute("PDS_USER_INFO", sessionVo);
			}

			//로그인 이력 정보를 관리한다.
			try{
				Map<String, Object> insertparam = new HashMap<String, Object>();
				insertparam.put("empNo", sessionVo.getUserId());
				insertparam.put("loginIp", sessionVo.getLoginIp());
				loin01Mapper.insertLogin(insertparam);
			}catch(Exception e){

			}
		}

		return result;
	}

	private Map<String, String> setPropty(HashMap<String, Object> param) {
		Map<String, String> inf = new HashMap<String, String>();

		if (param != null) {
			String stgUserId = StringUtils.defaultIfEmpty((String)param.get("stgUserId"), StringUtils.EMPTY);
			String userId = StringUtils.defaultIfEmpty((String)param.get("userId"), StringUtils.EMPTY);

			inf.put("userId", sessionVo.getUserId());
			inf.put("userNm", sessionVo.getUserNm());
			inf.put("password", sessionVo.getPassword());
			inf.put("resetYn", sessionVo.getResetYn());
			inf.put("groupCd", sessionVo.getGroupCd());
			inf.put("authCd", sessionVo.getAuthCd());

		}

		return inf;
	}

	/**
	 *
	 * @Method : Validator
	 * @author ybLee
	 * @since 2021-01-19
	 * @Description :  로그인 처리 로직
	 *
	 *  -------------------------------------------------
	 *
	 * @return
	 */
	private Map<String, Object> Validator(SessionVO sessionVo, HashMap<String, Object> loginParam)  throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

    	String password = sessionVo.getPassword();

		HashMap<String, Object> param = new HashMap<String, Object>();
    	                        param.put("userId", sessionVo.getUserId());
    	                        //param.put("extNo", sessionVo.getDn());

		if (!StringUtils.defaultIfEmpty((String)loginParam.get("password"), StringUtils.EMPTY).equals(password)) { // 패스워드 불일치
			result.put("result", "F");
			result.put("message", "로그인에 실패했습니다.");

		} else {
			result.put("result", "S");
			// 로그인 후 to do
		}

		return result;
	}

}