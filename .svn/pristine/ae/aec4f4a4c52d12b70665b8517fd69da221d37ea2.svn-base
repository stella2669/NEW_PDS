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
package com.llynx.cmn.services.paging;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.llynx.cmn.util.PagingVO;
import com.llynx.cmn.util.StringUtil;

/**
 * @Class Name : PagingService.java
 * @Description : PagingService Class
 * @author MOON KI PYOUNG
 * @since 2020-09-01
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-09-01  MOON KI PYOUNG         최초생성
 *
 *</pre>
 */
@Service
public class PagingService {
	
	private static final Logger logger = LoggerFactory.getLogger(PagingService.class);
	
	public Map<String, Object> getPaging(Map<String, Object> paramMap) throws Exception {
		int pageNo = StringUtil.convertToInt(paramMap.get("pageNo"), 1);
		int listSize = StringUtil.convertToInt(paramMap.get("pageSize"), 30);
		PagingVO pagingVo = new PagingVO(pageNo, listSize, (int) paramMap.get("totalCount"));
		paramMap.put("paging", pagingVo);
		logger.debug(pagingVo.toString());
		return pagingVo.getSrchMap(paramMap);
	}
}
