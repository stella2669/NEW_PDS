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
package com.llynx.modules.sy.au;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Class Name : SYAU01_Service.java
 * @Description : SYAU01_Service Class
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
@RemoteProxy(name="SYAU01_Service")
public class SYAU01_Service {

	private static final Logger logger = LoggerFactory.getLogger(SYAU01_Service.class);
		
	@Autowired
	private SYAU01_Mapper syau01_Mapper;

	/**
	 * 권한코드 리스트 조회
	 * @Method : getAuthCdList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> getAuthCdList(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> list = syau01_Mapper.getAuthCdList(paramMap);
			result.put("result", "S");
			result.put("list",list);			
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "권한코드 리스트를 가져오는데 실패하였습니다,");
			logger.error(npe.getMessage());
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "권한코드 리스트를 가져오는데 실패하였습니다,");
			logger.error(e.getMessage());
		}
		return result;
	}	
	

	/**
	 * 권한코드 중복체크
	 * @Method : dupCheckAuthCd
	 * @author ybLee
	 * @since 2021-04-28
	 * @Description : 
	 *  -------------------------------------------------
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> dupCheckAuthCd(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		if(!syau01_Mapper.dupCheckAuthCd(paramMap)) {
			result.put("result", "S");
		}else {
			result.put("result", "F");			
		}		
		return result;
	}
	
	/**
	 * 권한코드 저장
	 * @Method : insertAuthCd
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> insertAuthCd(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			syau01_Mapper.insertAuthCd(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "권한코드 저장 도중 오류가 발생하였습니다.");
		}
		return result;
	}	

	/**
	 * 권한코드 수정
	 * @Method : updateAuthCd
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> updateAuthCd(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			syau01_Mapper.updateAuthCd(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "권한코드 수정 도중 오류가 발생하였습니다.");
		}
		return result;
	}		

	/**
	 * 권한코드 삭제
	 * @Method : deleteAuthCd
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> deleteAuthCd(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			syau01_Mapper.deleteAuthCd(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "권한코드 삭제 도중 오류가 발생하였습니다.");
		}
		return result;
	}	
}
