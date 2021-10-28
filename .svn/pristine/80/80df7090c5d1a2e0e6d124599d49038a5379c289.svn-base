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
package com.llynx.modules.us.au;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Class Name : USAUT01_Service.java
 * @Description : USAUT01_Service Class
 * @author ybLee
 * @since 2021-01-20
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021-01-20  ybLee     최초생성
 *
 *</pre>
 */
@RemoteProxy(name="USAU02_Service")
public class USAU02_Service {

	private static final Logger logger = LoggerFactory.getLogger(USAU02_Service.class);

	@Autowired
	private USAU02_Mapper syau02_Mapper;

//권한코드 그리드 들어가는 데이터
	@RemoteMethod
	public Map<String,Object> getAuthList(Map<String, Object> paramMap) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> list = syau02_Mapper.getAuthList(paramMap);
			result.put("result", "S");
			result.put("list",list);
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "권한 리스트를 가져오는데 실패하였습니다,");
			logger.error(npe.getMessage());
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "권한 리스트를 가져오는데 실패하였습니다,");
			logger.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 개인별 프로그램
	 * @Method : getProgList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description :
	 *  -------------------------------------------------
	 * @param
	 * @return
	 */
	@RemoteMethod
	public Map<String, Object> getProgList(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String,Object>> list = syau02_Mapper.getProgList(paramMap);
			result.put("result", "S");
			result.put("list", list);
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "권한별 프로그램 권한 리스트를 가져오는데 실패하였습니다.");
			logger.error(npe.getMessage());
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "권한별 프로그램 권한 리스트를 가져오는데 실패하였습니다.");
			logger.error(e.getMessage());
		}
		return result;
	}

	@RemoteMethod
	public Map<String, Object> insertProgAuth(Map<String, Object> paramMap, List<String> progList) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			syau02_Mapper.deleteProgDefaultAuth(paramMap);
			for(int i=0;i<progList.size();i++) {
				paramMap.put("progCd", progList.get(i));
				syau02_Mapper.insertProgDefaultAuth(paramMap);
			}
			List<Map<String, Object>> authUserList = syau02_Mapper.getThisAuthUser(paramMap);
			for(int i=0;i<authUserList.size();i++) {
				for(int j=0;j<progList.size();j++) {
					Map<String, Object> param= new HashMap<String, Object>();
					param.put("userId", authUserList.get(i).get("userId"));
					param.put("progCd", progList.get(j));
					param.put("crtUserId", paramMap.get("userId"));
					syau02_Mapper.chAuthProgAdd(param);
				}
			}

			result.put("result", "S");
		} catch (Exception e) {
			result.put("result", "F");
		}
		return result;
	}
}
