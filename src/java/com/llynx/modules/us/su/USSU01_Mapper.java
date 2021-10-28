package com.llynx.modules.us.su;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface USSU01_Mapper {

	public List<Map<String,Object>> getUserList1(Map<String,Object> paramMap);
	
	public List<Map<String,Object>> getUserList2(Map<String,Object> paramMap);
	
	public List<Map<String,Object>> getNotSkillUserList();
	
	public void deleteUserList1(Map<String,Object> paramMap);
	
	public void deleteUserList2(Map<String,Object> paramMap);
	
	public void insertUserList1(Map<String,Object> paramMap);

	public void insertUserList2(Map<String,Object> paramMap);
	
	public List<Map<String,Object>> getSkillTypeList();
	
	public List<Map<String,Object>> getSkillList(Map<String,Object> paramMap);
}
