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
package com.llynx.modules.cu.nc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.llynx.cmn.services.paging.PagingService;


/**
 * @Class Name : CUNC01_Service.java
 * @Description : CUNC01_Service Class
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
@RemoteProxy(name="CUNC01_Service")
public class CUNC01_Service {

	private static final Logger logger = LoggerFactory.getLogger(CUNC01_Service.class);
		
	@Autowired
	private CUNC01_Mapper cunc01Mapper;
	
	/**
	 * DNC 리스트 조회
	 * @Method : getDncList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> getDncList(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String, Object>> list = null;
		try {
			int totalCount = cunc01Mapper.getTotalCount(paramMap);
			paramMap.put("totalCount", totalCount);
			PagingService ps = new PagingService();
			Map<String, Object> pagingMap = ps.getPaging(paramMap);
			
			if(totalCount>0) {
				list = cunc01Mapper.getDncList(pagingMap);
			}
			
			result.put("result", "S");
			result.put("list",list);			
			result.put("paging",pagingMap);			
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "DNC 리스트를 가져오는데 실패하였습니다,");
			logger.error(npe.getMessage());
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "DNC 리스트를 가져오는데 실패하였습니다,");
			logger.error(e.getMessage());
		}
		return result;
	}	
	
	/**
	 * DNC 중복체크
	 * @Method : dupCheckDnc
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> dupCheckDnc(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		if(cunc01Mapper.dupCheckDnc(paramMap)==false) {
			result.put("result", "S");
		}else {
			result.put("result", "F");			
		}		
		return result;
	}
	
	/**
	 * DNC 저장
	 * @Method : insertDnc
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> insertDnc(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cunc01Mapper.insertDnc(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "DNC 저장 도중 오류가 발생하였습니다.");
		}
		return result;
	}	

	/**
	 * DNC 수정
	 * @Method : updateDnc
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> updateDnc(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cunc01Mapper.updateDnc(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "DNC 수정 도중 오류가 발생하였습니다.");
		}
		return result;
	}		

	/**
	 * DNC 삭제
	 * @Method : deleteDnc
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> deleteDnc(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cunc01Mapper.deleteDnc(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "DNC 삭제 도중 오류가 발생하였습니다.");
		}
		return result;
	}	
}
