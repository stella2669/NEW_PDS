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
package com.llynx.cmn.session;

import java.io.Serializable;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import egovframework.com.cmm.SessionVO;

/**
 * @Class Name : SessionBindingListener.java
 * @Description : SessionBindingListener Class
 * @author USER
 * @since 2020-11-05
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-11-05  USER         최초생성
 *
 *</pre>
 */
// @WebListener
@Component
public class SessionBindingListener implements HttpSessionAttributeListener,Serializable { // HttpSessionListener, HttpSessionBindingListener,
	private static final long serialVersionUID = -9049468742138909430L;

	private static final Logger logger = LoggerFactory.getLogger(SessionBindingListener.class);
	private static final String GROBAL_SESSION_ID = "TCM_USER_INFO";
	
	private static SessionBindingListener sessionListener = null;
	private static ConcurrentHashMap<String, HttpSession> sessionTable = new ConcurrentHashMap<String, HttpSession>();
	
	public SessionBindingListener() {}
	
	public static synchronized SessionBindingListener getInstance() {
		if (sessionListener == null) {
			logger.warn("listener is null");
			sessionListener = new SessionBindingListener();
		}
		
		return sessionListener;
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe) {
		addUser(hsbe.getName(), hsbe.getSession());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
	*/
	@Override
	public void attributeRemoved(HttpSessionBindingEvent hsbe) {
		removeUser(hsbe.getName());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent hsbe) {
	}
	
	private void addUser(String sessonId, HttpSession session) {
		if (!findById(sessonId)) {
			sessionTable.put(sessonId, session);
		}

		if (logger.isInfoEnabled()) {
			logger.info("session --> add: {} , count: {}", sessonId, sessionTable.size());
		}
	}
	
	private void removeUser(String sessonId) {		
		sessionTable.remove(sessonId);

		if (logger.isInfoEnabled()) {
			logger.info("session --> remove: {} , count: {}", sessonId, sessionTable.size());
		}
		
//		if (findById(sessonId)) {	
//			String key = "";
//			Enumeration<String> keys = sessionTable.keys();
//			while(keys.hasMoreElements()) {
//				key = keys.nextElement();
//				if (key.equals(sessonId)) {
//					sessionTable.get(key).invalidate();
//				}
//			}
//		}
	}
	
	public static boolean findById(String userId) {
		return sessionTable.containsKey(userId);
	}
	
	public static SessionVO getUserInfo(String userId) {
		SessionVO userInfo = new SessionVO();
//		try {
			HttpSession session =  sessionTable.get(userId);
			userInfo = (SessionVO) session.getAttribute(userId);
//		} catch (Exception e) {
//			logger.error("", e);
//		}
		
		return userInfo;
	}

	public static String findUserId(HttpSession session) {
		String userId = "";
		SessionVO sessionVo = null;
//		try {
			sessionVo = (SessionVO) session.getAttribute(GROBAL_SESSION_ID);
			if (sessionVo != null) {
				userId = sessionVo.getUserId();
			}
//		} catch (Exception e) {
//			logger.error("", e);
//		}
		
		return userId;
	}
}
