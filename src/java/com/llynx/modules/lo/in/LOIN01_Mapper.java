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
package com.llynx.modules.lo.in;

import java.util.HashMap;
import java.util.Map;

import egovframework.com.cmm.SessionVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : IPLA01_Mapper.java
 * @Description : IPLA01_Mapper Class
 * @author ybLee
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
@Mapper
public interface LOIN01_Mapper {

	/**
	 * 
	 * @Method : findUser
	 * @author ybLee
	 * @since 2021-04-16
	 * @Description : 
	 *    로그인 사용자 조회
	 *
	 *  -------------------------------------------------
	 *
	 * @return
	 */
	public SessionVO findUser(Map<String, Object> param) throws Exception;

	
	public int insertLogin(Map<String, Object>  param);
}
