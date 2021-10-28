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

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : AJB0001Mapper.java
 * @Description : AJB0001Mapper Class
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

@Mapper
public interface SYPG01_Mapper {

	/**
	 * 프로그램리스트 조회
	 * @Method : getProgCdList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	public List<Map<String, Object>> getProgCdList(Map<String, Object> paramMap);
		
	/**
	 * 프로그램코드 중복체크
	 * @Method : dupCheckProgCd
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */		
	public boolean dupCheckProgCd(Map<String, Object> paramMap);
	
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
	public void insertProgCd(Map<String, Object> paramMap);
	
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
	public void updateProgCd(Map<String, Object> paramMap);
	public void updateAuthProgUser(Map<String, Object> paramMap);
	public void updateAuthProg(Map<String, Object> paramMap);
	
	
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
	public void deleteProgCd(Map<String, Object> paramMap);	
	public void deleteProgAuthUser(Map<String, Object> paramMap);	
	public void deleteProgAuth(Map<String, Object> paramMap);	
}
