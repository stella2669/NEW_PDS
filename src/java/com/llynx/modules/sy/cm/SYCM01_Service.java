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
package com.llynx.modules.sy.cm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Class Name : SYCOM01Service.java
 * @Description : SYCOM01Service Class
 * @author ybLee
 * @since 2021-01-19
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021-01-19  ybLee     최초생성
 *
 *</pre>
 */
@RemoteProxy(name="SYCM01_Service")
public class SYCM01_Service {

	private static final Logger logger = LoggerFactory.getLogger(SYCM01_Service.class);
	
	@Autowired
	private SYCM01_Mapper sycm01Mapper;
	
	@RemoteMethod
	public Map<String,Object> dupCheckLcd(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		if(!sycm01Mapper.dupCheckLcd(paramMap)) {
			result.put("result", "S");
		}else {
			result.put("result", "F");			
		}		
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> dupCheckScd(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		if(!sycm01Mapper.dupCheckScd(paramMap)) {
			result.put("result", "S");
		}else {
			result.put("result", "F");			
		}		
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> getComLcdList(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> list = sycm01Mapper.getComLcdList(paramMap);
			result.put("result", "S");
			result.put("list",list);			
		} catch(NullPointerException npe) {
			logger.error(npe.getMessage());
			result.put("result", "F");
			result.put("msg", "공통코드 리스트를 가져오는데 실패하였습니다,");			
		} catch(Exception e) {
			logger.error(e.getMessage());
			result.put("result", "F");
			result.put("msg", "공통코드 리스트를 가져오는데 실패하였습니다,");			
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> getComScdList(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> list = sycm01Mapper.getComScdList(paramMap);
			result.put("result", "S");
			result.put("list",list);			
		} catch(NullPointerException npe) {
			logger.error(npe.getMessage());
			result.put("result", "F");
			result.put("msg", "상세코드 리스트를 가져오는데 실패하였습니다,");			
		} catch(Exception e) {
			logger.error(e.getMessage());
			result.put("result", "F");
			result.put("msg", "상세코드 리스트를 가져오는데 실패하였습니다,");			
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> insertLcd(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			sycm01Mapper.insertLcd(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "공통코드 저장 도중 오류가 발생하였습니다.");
		}
		return result;
	}
		
	@RemoteMethod
	public Map<String,Object> updateLcd(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			sycm01Mapper.updateLcd(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "공통코드 수정 도중 오류가 발생하였습니다.");
		}
		return result;
	}

	@RemoteMethod	
	public Map<String,Object> deleteLcd(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			sycm01Mapper.deleteLcd(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "공통코드 삭제 도중 오류가 발생하였습니다.");
		}
		return result;
	}

	@RemoteMethod
	public Map<String,Object> insertScd(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			sycm01Mapper.insertScd(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "공통코드 저장 도중 오류가 발생하였습니다.");
		}
		return result;
	}
		
	@RemoteMethod
	public Map<String,Object> updateScd(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			sycm01Mapper.updateScd(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "공통코드 수정 도중 오류가 발생하였습니다.");
		}
		return result;
	}

	@RemoteMethod
	public Map<String,Object> deleteScd(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			sycm01Mapper.deleteScd(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "공통코드 삭제 도중 오류가 발생하였습니다.");
		}
		return result;
	}
}
