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
package com.llynx.modules.fr.fr;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : FRFRA01_Service.java
 * @Description : FRFRA01_Service Class
 * @author ybLee
 * @since 2021-01-19
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021-01-19  ybLee         최초생성
 *
 *</pre>
 */
@RemoteProxy(name="FRFR01_Service")
public class FRFR01_Service extends EgovAbstractServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(FRFR01_Service.class);

	@Autowired
	private FRFR01_Mapper frfr01Mapper;

	/**
	 * 캠페인 상담원 모니터링 데이터
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	@RemoteMethod
	public Map<String, Object> getCampAgentMnData() throws SQLException{
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result = frfr01Mapper.getIntroAgentMonData();
			result.put("result", "S");
		} catch(Exception e) {
			result.put("result", "F");
			logger.error(e.getMessage());
		}
		return result;
	}
}