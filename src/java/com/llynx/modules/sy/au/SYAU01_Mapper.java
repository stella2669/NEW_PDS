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

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : SYAU01_Mapper.java
 * @Description : SYAU01_Mapper Class
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
public interface SYAU01_Mapper {
	
	/**
	 * 권한리스트 조회
	 * @Method : getAuthCdList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	public List<Map<String, Object>> getAuthCdList(Map<String, Object> paramMap);
		
	/**
	 * 권한코드 중복체크
	 * @Method : dupCheckAuthCd
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */		
	public boolean dupCheckAuthCd(Map<String, Object> paramMap);
	
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
	public void insertAuthCd(Map<String, Object> paramMap);
	
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
	public void updateAuthCd(Map<String, Object> paramMap);
	
	
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
	public void deleteAuthCd(Map<String, Object> paramMap);			
}
