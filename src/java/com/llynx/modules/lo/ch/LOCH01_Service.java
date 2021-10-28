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
package com.llynx.modules.lo.ch;

import java.util.HashMap;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : IPLC01_Service.java
 * @Description : IPLC01_Service Class
 * @author USER
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
@RemoteProxy(name="LOCH01_Service")
public class LOCH01_Service extends EgovAbstractServiceImpl {
	private static final Logger logger = LoggerFactory.getLogger(LOCH01_Service.class);

	@Autowired
	private LOCH01_Mapper loch01_Mapper;
	
	@RemoteMethod
	public Map<String, Object> findUser(HashMap<String, Object> param) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> userInfo = null;
		try {
			userInfo = loch01_Mapper.findUser(param);

			if (userInfo == null) { // 조회된 사용자가 없습니다.
				result.put("result", "F");		
				result.put("message", "비밀번호변경 사용자가 아닙니다.\nID를 다시 확인하시기 바랍니다.");	    			
	    	} else {
	    		result.put("userId", (String)userInfo.get("userId"));
	    		result.put("password", (String)userInfo.get("password"));
	    		result.put("userInfo", userInfo);
				result.put("result", "S");	
	    	}
		} catch (DataAccessException e) {
			logger.error("", e);
			
			result.put("result", "F");		
			result.put("message", "비밀번호 변경중 오류가 발생되었습니다.\n관리자에게 문의하세요.");
		} catch (Exception e) {
			logger.error("", e);
			
			result.put("result", "F");		
			result.put("message", "비밀번호 변경중 오류가 발생되었습니다.\n관리자에게 문의하세요.");
		}
		
		return result;
	}
	
	@RemoteMethod
	public Map<String, Object> updateUserPswd(HashMap<String, Object> param) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			int userInfo = loch01_Mapper.updateUserPswd(param);
			if (userInfo>0) {
				result.put("result", "S");		
				result.put("message", "비밀번호가 변경되었습니다.");
			} else {
				result.put("result", "F");		
				result.put("message", "비밀번호 변경되지 않았습니다.\n다시 시도하세요.");
			}			
			if(logger.isInfoEnabled()) {
				logger.info("{} 사용자 비밀번호 변경 {}", param.get("userId").toString(), userInfo>0?"성공":"실패");
			}
		} catch (DataAccessException e) {
			logger.error("", e);			
			result.put("result", "F");		
			result.put("message", "비밀번호 변경중 오류가 발생되었습니다.\n관리자에게 문의하세요.");
		} catch (Exception e) {
			logger.error("", e);			
			result.put("result", "F");		
			result.put("message", "비밀번호 변경중 오류가 발생되었습니다.\n관리자에게 문의하세요.");
		}
		
		return result;
	}

}
