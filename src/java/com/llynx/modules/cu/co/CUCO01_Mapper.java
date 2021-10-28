package com.llynx.modules.cu.co;


import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : CUCO01_Mapper.java
 * @Description : CUCO01_Mapper Class
 * @author ybLee
 * @since 2021-01-19
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021-10-26  ybLee     최초생성
 *
 *</pre>
 */

@Mapper
public interface CUCO01_Mapper {
	
	public List<Map<String, Object>> getContactList(Map<String, Object> paramMap);	
	
	public void insertContactlist(Map<String, Object> paramMap);

	public void updateContactList(Map<String,Object> paramMap);

	public void deleteContactList(Map<String,Object> paramMap);
	
}