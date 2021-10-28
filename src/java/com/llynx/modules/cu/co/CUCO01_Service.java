package com.llynx.modules.cu.co;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.llynx.modules.cu.at.CUAT01_Mapper;

@RemoteProxy(name="CUCO01_Service")
public class CUCO01_Service {

	private static final Logger logger = LoggerFactory.getLogger(CUCO01_Service.class);
	
	@Autowired
	private CUCO01_Mapper cuco01Mapper;
	@RemoteMethod
	public Map<String,Object> getContactList(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> list = cuco01Mapper.getContactList(paramMap);
			result.put("result", "S");
			result.put("list",list);			
		} catch(NullPointerException npe) {
			logger.error(npe.getMessage());
			result.put("result", "F");
			result.put("msg", "컨택 리스트를 가져오는데 실패하였습니다,");			
		} catch(Exception e) {
			logger.error(e.getMessage());
			result.put("result", "F");
			result.put("msg", "컨택 리스트를 가져오는데 실패하였습니다,");			
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> insertContactlist(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cuco01Mapper.insertContactlist(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "컨택리스트 저장 도중 오류가 발생하였습니다.");
		}
		return result;
	}

	@RemoteMethod
	public Map<String,Object> updateContactList(Map<String,Object> paramMap){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cuco01Mapper.updateContactList(paramMap);
			result.put("result", "S");
		}catch(Exception e) {
			result.put("result", "F");
			result.put("msg", "컨택리스트 수정 도중 오류가 발생하였습니다.");
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> deleteContactList(Map<String,Object> paramMap){
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cuco01Mapper.deleteContactList(paramMap);
			result.put("result", "S");
		}catch(Exception e) {
			result.put("result", "F");
			result.put("msg", "컨택리스트 삭제 도중 오류가 발생하였습니다.");
		}
		return result;
	}
}
