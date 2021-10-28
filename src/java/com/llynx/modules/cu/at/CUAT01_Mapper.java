package com.llynx.modules.cu.at;


import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : CUAT01_Mapper.java
 * @Description : CUAT01_Mapper Class
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
public interface CUAT01_Mapper {
	
	
	public List<Map<String, Object>> getAttrList(Map<String, Object> paramMap);
	
	public List<Map<String,Object>> getAttrListY();
	
	public List<Map<String, Object>> getAttrInfoList(Map<String, Object> paramMap);
	
	public void insertAttrlist(Map<String, Object> paramMap);
	
	public void insertAttrInfo(Map<String, Object> paramMap);
	
	public void updateAttrlist(Map<String, Object> paramMap);
	
	public void updateAttrInfo(Map<String, Object> paramMap);
	
	public void deleteAttrlist(Map<String, Object> paramMap);
	
	public void deleteAttrInfo(Map<String, Object> paramMap);

	
}