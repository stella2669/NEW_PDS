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

import org.springframework.dao.DataAccessException;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : LOLOG03Mapper.java
 * @Description : LOLOG03Mapper Class
 * @author user
 * @since 2020-08-19
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-08-19  user         최초생성
 *
 *</pre>
 */
@Mapper
public interface LOCH01_Mapper {

	/**
	 * 
	 * @Method : findUser
	 * @author ybLee
	 * @since 2021-04-16
	 * @Description : 
	 *    비밀번호 변경 사용자 조회
	 *
	 *  -------------------------------------------------
	 *
	 * @return
	 */
	public HashMap<String, Object> findUser(HashMap<String, Object> param) throws DataAccessException;
	
	/**
	 * 
	 * @Method : updatePassword
	 * @author ybLee
	 * @since 2021-04-16
	 * @Description : 
	 *    비밀번호 변경
	 *
	 *  -------------------------------------------------
	 *
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int updateUserPswd(HashMap<String, Object> param) throws DataAccessException;
	
}
