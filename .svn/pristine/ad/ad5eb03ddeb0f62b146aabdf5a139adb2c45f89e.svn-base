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
package com.llynx.cmn.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;



/**
 * @Class Name : ExcelService.java
 * @Description : ExcelService Class
 * @author MOON KI PYOUNG
 * @since 2020-09-04
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-09-04  MOON KI PYOUNG         최초생성
 *
 *</pre>
 */
@Service
public class ExcelService {
	/*
	 * paramMap: colModel, title, excelData
	 * return map: title, items, dataKey, excelData
	 * */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getExcelInfo(HashMap<String, Object> paramMap) throws Exception {
		List<HashMap<String, Object>> colModel = (List<HashMap<String, Object>>) paramMap.get("colModel");
		List<Object> groupHeader = (List<Object>) paramMap.get("groupHeader");
		ArrayList<String> items = new ArrayList<String>();
		ArrayList<String> dataKey = new ArrayList<String>();
		
		String title = (String) paramMap.get("title");
		
		for(int i = 0; i < colModel.size(); i++ ) {
			HashMap<String, Object> item = colModel.get(i);
			
			// 엑셀 항목 및 조회 데이터중 엑셀 출력값 설정
			if ((item.get("hidden") == null || !(Boolean)item.get("hidden")) // 숨김처리된 데이터는 버린다.
					&& item.get("name") != null && !item.get("name").toString().startsWith("button")) { // 버튼으로 시작하는 경우 버림
				items.add((String)item.get("label"));
				dataKey.add((String)item.get("name"));
			}
		}
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("title", title);
		model.put("groupHeader", groupHeader);
		model.put("items", items);
		model.put("dataKey", dataKey);
		model.put("excelData", paramMap.get("excelData"));
		
		return model;
	}
}
