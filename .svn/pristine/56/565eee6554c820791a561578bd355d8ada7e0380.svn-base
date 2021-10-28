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
package com.llynx.modules.sy.pg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.llynx.modules.fr.me.FRME01_Mapper;

/**
 * @Class Name : SYPRO01_Service.java
 * @Description : SYPRO01_Service Class
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
@RemoteProxy(name="SYPG01_Service")
public class SYPG01_Service {

	private static final Logger logger = LoggerFactory.getLogger(SYPG01_Service.class);
	
	@Autowired
	private SYPG01_Mapper sypg01_Mapper;
	
	@Autowired
	private FRME01_Mapper frme01_Mapper;
	
	/**
	 * 메뉴코드 리스트 조회
	 * @Method : getMenuCodeList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */
	@RemoteMethod
	public List<Map<String, Object>> getMenuCodeList() throws Exception{
		return frme01_Mapper.mainMenuList();
	}	


	/**
	 * 프로그램코드 리스트 조회
	 * @Method : getProgCdList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> getProgCdList(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> list = sypg01_Mapper.getProgCdList(paramMap);
			result.put("result", "S");
			result.put("list",list);			
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "프로그램코드 리스트를 가져오는데 실패하였습니다,");
			logger.error(npe.getMessage());
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "프로그램코드 리스트를 가져오는데 실패하였습니다,");
			logger.error(e.getMessage());
		}
		return result;
	}	
	
	/**
	 * 프로그램코드 중복체크
	 * @Method : dupCheckProgCd
	 * @author ybLee
	 * @since 2021-04-28
	 * @Description : 
	 *  -------------------------------------------------
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> dupCheckProgCd(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		if(!sypg01_Mapper.dupCheckProgCd(paramMap)) {
			result.put("result", "S");
		}else {
			result.put("result", "F");			
		}		
		return result;
	}
	
	/**
	 * 프로그램코드 저장
	 * @Method : insertProgCd
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> insertProgCd(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			sypg01_Mapper.insertProgCd(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "프로그램코드 저장 도중 오류가 발생하였습니다.");
		}
		return result;
	}	

	/**
	 * 프로그램코드 수정
	 * @Method : updateProgCd
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> updateProgCd(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			sypg01_Mapper.updateProgCd(paramMap);
			sypg01_Mapper.updateAuthProg(paramMap);
			sypg01_Mapper.updateAuthProgUser(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "프로그램코드 수정 도중 오류가 발생하였습니다.");
		}
		return result;
	}		

	/**
	 * 프로그램코드 삭제
	 * @Method : deleteProgCd
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> deleteProgCd(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			sypg01_Mapper.deleteProgCd(paramMap);
			sypg01_Mapper.deleteProgAuth(paramMap);
			sypg01_Mapper.deleteProgAuthUser(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "프로그램코드 삭제 도중 오류가 발생하였습니다.");
		}
		return result;
	}		
	
}
