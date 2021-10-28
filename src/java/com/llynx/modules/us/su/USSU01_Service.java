package com.llynx.modules.us.su;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RemoteProxy(name="USSU01_Service")
public class USSU01_Service {
	
	private static final Logger logger = LoggerFactory.getLogger(USSU01_Service.class);
	
	@Autowired
	private USSU01_Mapper ussu01_Mapper;
	
	@RemoteMethod
	public Map<String,Object> getUserList1(Map<String,Object> paramMap) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String,Object>>list = ussu01_Mapper.getUserList1(paramMap);
			result.put("result", "S");
			result.put("list", list);
		}catch(NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "스킬 별 사용자 리스트를 가져오는데 실패하였습니다,");
			logger.error(npe.getMessage());
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> getUserList2(Map<String,Object> paramMap) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String,Object>>list = ussu01_Mapper.getUserList2(paramMap);
			result.put("result", "S");
			result.put("list", list);
		}catch(NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "스킬 별 사용자 리스트를 가져오는데 실패하였습니다,");
			logger.error(npe.getMessage());
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> getNotSkillUserList() throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String,Object>>list = ussu01_Mapper.getNotSkillUserList();
			result.put("result", "S");
			result.put("list", list);
		}catch(NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "스킬 별 사용자 리스트를 가져오는데 실패하였습니다,");
			logger.error(npe.getMessage());
		}
		
		return result;
	}
		
	@RemoteMethod 
	public Map<String,Object> updateUserList(Map<String,Object> paramMap, String[] idList1, String[] idList2) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			ussu01_Mapper.deleteUserList1(paramMap);
			ussu01_Mapper.deleteUserList2(paramMap);
			if(idList1.length != 0) {
				for(int i = 0; i< idList1.length ; i++) {
					paramMap.put("checkedUserId1", idList1[i]);
					ussu01_Mapper.insertUserList1(paramMap);
				}
			}
			if(idList2.length != 0) {
				for(int i = 0; i < idList2.length; i++) {
					paramMap.put("checkedUserId2", idList2[i]);
					ussu01_Mapper.insertUserList2(paramMap);
				}
			}
			result.put("result", "S");
		}catch (Exception e) {
			result.put("result", "F");
		}
		return result;
	}

	@RemoteMethod
	public List<Map<String,Object>> getSkillTypeList() throws Exception{
		return ussu01_Mapper.getSkillTypeList();
	}
	
	@RemoteMethod
	public List<Map<String,Object>> getSkillList(Map<String,Object> paramMap) throws Exception{
		return ussu01_Mapper.getSkillList(paramMap);
	}
}
	
