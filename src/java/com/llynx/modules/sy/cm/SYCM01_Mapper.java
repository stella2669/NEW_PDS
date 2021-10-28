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

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : SYCOM01Mapper.java
 * @Description : SYCOM01Mapper Class
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

@Mapper
public interface SYCM01_Mapper {
	
	public boolean dupCheckLcd(Map<String, Object> paramMap);
	
	public boolean dupCheckScd(Map<String, Object> paramMap);
	
	public List<Map<String, Object>> getComLcdList(Map<String, Object> paramMap);

	public List<Map<String, Object>> getComScdList(Map<String, Object> paramMap);

	public void insertLcd(Map<String, Object> paramMap);

	public void updateLcd(Map<String, Object> paramMap);

	public void deleteLcd(Map<String, Object> paramMap);

	public void insertScd(Map<String, Object> paramMap);

	public void updateScd(Map<String, Object> paramMap);

	public void deleteScd(Map<String, Object> paramMap);
}
