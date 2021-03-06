package com.llynx.modules.cu.at;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.llynx.modules.sy.cm.SYCM01_Mapper;

@RemoteProxy(name="CUAT01_Service")
public class CUAT01_Service {

	private static final Logger logger = LoggerFactory.getLogger(CUAT01_Service.class);
	
	@Autowired
	private CUAT01_Mapper cuat01Mapper;
	
	@RemoteMethod
	public Map<String,Object> getAttrList(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> list = cuat01Mapper.getAttrList(paramMap);
			result.put("result", "S");
			result.put("list",list);			
		} catch(NullPointerException npe) {
			logger.error(npe.getMessage());
			result.put("result", "F");
			result.put("msg", "특성 리스트를 가져오는데 실패하였습니다,");			
		} catch(Exception e) {
			logger.error(e.getMessage());
			result.put("result", "F");
			result.put("msg", "특성 리스트를 가져오는데 실패하였습니다,");			
		}
		return result;
	}
	
	@RemoteMethod
	public List<Map<String,Object>> getAttrListY(){
		return cuat01Mapper.getAttrListY();
	}
	
	@RemoteMethod
	public Map<String,Object> getAttrInfoList(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> list = cuat01Mapper.getAttrInfoList(paramMap);
			result.put("result", "S");
			result.put("list",list);			
		} catch(NullPointerException npe) {
			logger.error(npe.getMessage());
			result.put("result", "F");
			result.put("msg", "특성목록 정보를 가져오는데 실패하였습니다,");			
		} catch(Exception e) {
			logger.error(e.getMessage());
			result.put("result", "F");
			result.put("msg", "특성목록 정보를 가져오는데 실패하였습니다,");			
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> insertAttrlist(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cuat01Mapper.insertAttrlist(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "특성리스트 저장 도중 오류가 발생하였습니다.");
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> insertAttrInfo(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cuat01Mapper.insertAttrInfo(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "특성목록정보 저장 도중 오류가 발생하였습니다.");
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> updateAttrlist(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cuat01Mapper.updateAttrlist(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "특성리스트 정보 수정 도중 오류가 발생하였습니다.");
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> updateAttrInfo(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cuat01Mapper.updateAttrInfo(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "특성목록 정보 수정 도중 오류가 발생하였습니다.");
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> deleteAttrlist(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cuat01Mapper.deleteAttrlist(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "특성리스트 정보 삭제 도중 오류가 발생하였습니다.");
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String,Object> deleteAttrInfo(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cuat01Mapper.deleteAttrInfo(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "특성목록 정보 삭제 도중 오류가 발생하였습니다.");
		}
		return result;
	}
}
