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
package com.llynx.cmn.services.login;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import egovframework.com.cmm.SessionVO;

/**
 * @Class Name : CnsrService.java
 * @Description : CnsrService Class
 * @author felix.kim
 * @since 2020-08-28
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-08-28  felix.kim         최초생성
 *
 *</pre>
 */
@RemoteProxy(name="LoginService")
public class LoginService {
	
	public SessionVO getLoginInfo() {
		// HttpServletRequest
		HttpServletRequest request = null;
		if (RequestContextHolder.getRequestAttributes() != null) {
			request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		} else {
			WebContext ctx = WebContextFactory.get();
			request = ctx.getHttpServletRequest();
		}
		// Session
		HttpSession session = request.getSession();
		// SessionVO
		SessionVO sessionVo = (SessionVO) session.getAttribute("PDS_USER_INFO");
		return sessionVo;
	}
	
	@SuppressWarnings("unchecked")
	@RemoteMethod
	public Map<String, Object> getLoginInfoMap() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException  {
		return BeanUtils.describe(getLoginInfo());
	}
	
	public String getUserId() {
		SessionVO vo = getLoginInfo();
		if (vo == null) {
			return null;
		}
		return vo.getUserId();
	}
	
	public String getUserNm() {
		SessionVO vo = getLoginInfo();
		if (vo == null) {
			return null;
		}
		return vo.getUserNm();
	}
	
	public String getAuthCd() {
		SessionVO vo = getLoginInfo();
		if (vo == null) {
			return null;
		}
		return vo.getAuthCd();
	}

	public String getGroupCd() {
		SessionVO vo = getLoginInfo();
		if (vo == null) {
			return null;
		}
		return vo.getGroupCd();
	}
	
	public String getRankCd() {
		SessionVO vo = getLoginInfo();
		if (vo == null) {
			return null;
		}
		return vo.getRankCd();
	}
	
	public String getStCd() {
		SessionVO vo = getLoginInfo();
		if (vo == null) {
			return null;
		}
		return vo.getStCd();
	}
	
	public String getUserMail() {
		SessionVO vo = getLoginInfo();
		if(vo == null) {
			return null;
		}
		return vo.getUserMail();
	}
	
	public String getLoginIp() {
		SessionVO vo = getLoginInfo();
		if (vo == null) {
			return null;
		}
		return vo.getLoginIp();
	}
}
