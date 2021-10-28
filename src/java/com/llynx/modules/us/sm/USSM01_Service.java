package com.llynx.modules.us.sm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RemoteProxy(name="USSM01_Service")
public class USSM01_Service {
	private static final Logger logger = LoggerFactory.getLogger(USSM01_Service.class);
	
	@Autowired
	private USSM01_Mapper ussm01Mapper;

	/**
	 * 스킬 리스트 조회
	 * @Method : getSkillList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> getSkillList(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> list = ussm01Mapper.getSkillList(paramMap);
			result.put("result", "S");
			result.put("list",list);			
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "스킬 리스트를 가져오는데 실패하였습니다,");
			logger.error(npe.getMessage());
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "스킬 리스트를 가져오는데 실패하였습니다,");
			logger.error(e.getMessage());
		}
		return result;
	}	
	
	/**
	 * 스킬코드 중복체크
	 * @Method : dupCheckSkill
	 * @author ybLee
	 * @since 2021-04-28
	 * @Description : 
	 *  -------------------------------------------------
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> dupCheckSkill(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		if(!ussm01Mapper.dupCheckSkill(paramMap)) {
			result.put("result", "S");
		}else {
			result.put("result", "F");			
		}		
		return result;
	}
	
	/**
	 * 스킬 저장
	 * @Method : insertSkill
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> insertSkill(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			ussm01Mapper.insertSkill(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "스킬 저장 도중 오류가 발생하였습니다.");
		}
		return result;
	}	

	/**
	 * 스킬 수정
	 * @Method : updateSkill
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> updateSkill(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			ussm01Mapper.updateSkill(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "스킬 수정 도중 오류가 발생하였습니다.");
		}
		return result;
	}		

	/**
	 * 스킬 삭제
	 * @Method : deleteSkill
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> deleteSkill(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			ussm01Mapper.deleteSkill(paramMap);
			result.put("result", "S");			
		} catch (Exception e){
			result.put("result", "F");
			result.put("msg", "스킬 삭제 도중 오류가 발생하였습니다.");
		}
		return result;
	}	
}
