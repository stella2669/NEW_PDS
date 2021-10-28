package com.llynx.modules.us.um;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.llynx.modules.us.au.USAU01_Mapper;

/**
 * @Class Name : USAGT01_Service.java
 * @Description : USAGT01_Service Class
 * @author ISKRA
 * @since 2021-01-20
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021-01-20  ISKRA     최초생성
 *
 *</pre>
 */
@RemoteProxy(name="USUM01_Service")
public class USUM01_Service {
	private static final Logger logger = LoggerFactory.getLogger(USUM01_Service.class);
	
	@Autowired
	private USUM01_Mapper usum01_Mapper;
	
	@Autowired
	private USAU01_Mapper usau01_Mapper;
	
	@RemoteMethod
	public Map<String,Object> getAgtList(Map<String, Object> paramMap) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>(); 
		try {
			List<Map<String, Object>> list = usum01_Mapper.getAgtList(paramMap);
			result.put("result", "S");
			result.put("list",list);			
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "사용자 리스트를 가져오는데 실패하였습니다,");
			logger.error(npe.getMessage());
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "사용자 리스트를 가져오는데 실패하였습니다,");
			logger.error(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 사용자 ID 중복체크
	 * @Method : dupCheckUser
	 * @author ybLee
	 * @since 2021-04-28
	 * @Description : 
	 *  -------------------------------------------------
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> dupCheckUser(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		if(!usum01_Mapper.dupCheckUser(paramMap)) {
			result.put("result", "S");
		}else {
			result.put("result", "F");			
		}		
		return result;
	}
	
	/**
	 * 사용자 등록
	 * @Method : insertAgt01
	 * @author ISKRA
	 * @since 2021-01-25
	 * @Description : 
	 *  -------------------------------------------------
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> insertAgt01(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			usum01_Mapper.insertAgt01(paramMap);
			List<Map<String, Object>> list = usum01_Mapper.getProgList(paramMap);
			if(list!=null&&list.size()>0){
				paramMap.put("list", list);
				paramMap.put("authUserId",paramMap.get("userId"));
				paramMap.put("userId",paramMap.get("crtUserId"));
				for(int i=0; i<list.size(); i++){				
					paramMap.put("progCd",list.get(i).get("progCd"));
					usau01_Mapper.insertProgAuth(paramMap);
				}
			}
			result.put("result", "S");
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "사용자정보 등록 중 오류가 발생하였습니다.");
			logger.error(npe.getMessage());			
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "사용자정보 등록 중 오류가 발생하였습니다.");
			logger.error(e.getMessage());				
		}
		
		return result;
	}
	
	/**
	 * 사용자 변경
	 * @Method : updateAgt01
	 * @author ISKRA
	 * @since 2021-01-25
	 * @Description : 
	 *  -------------------------------------------------
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> updateAgt01(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try{
			usum01_Mapper.updateAgt01(paramMap);
			result.put("result", "S");
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "사용자정보 수정 중 오류가 발생하였습니다.");
			logger.error(npe.getMessage());				
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "사용자정보 수정 중 오류가 발생하였습니다.");
			logger.error(e.getMessage());				
		}
		return result;
	}
	
	/**
	 * 관리자 화면에서 비밀번호 변경
	 * @Method : changePawd
	 * @author ISKRA
	 * @since 2021-01-25
	 * @Description : 
	 *  -------------------------------------------------
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> changePawd(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try{
			usum01_Mapper.changePawd(paramMap);
			result.put("result", "S");
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "비밀번호 변경 중 오류가 발생하였습니다.");
			logger.error(npe.getMessage());				
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "비밀번호 변경 중 오류가 발생하였습니다.");
			logger.error(e.getMessage());				
		}
		return result;
		
	}
	
	/**
	 * 사용자 정보 삭제
	 * @Method : changePawd
	 * @author ISKRA
	 * @since 2021-01-25
	 * @Description : 
	 *  -------------------------------------------------
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> deleteAgt01(Map<String, Object> paramMap) {		
		Map<String,Object> result = new HashMap<String,Object>();
		try{
			usum01_Mapper.deleteAgt01(paramMap);
			paramMap.put("authEmpNo",paramMap.get("empNo"));
			usau01_Mapper.deleteProgAuth(paramMap);
			result.put("result", "S");
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "사용자정보 삭제 중 오류가 발생하였습니다.");
			logger.error(npe.getMessage());				
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "사용자정보 삭제 중 오류가 발생하였습니다.");
			logger.error(e.getMessage());				
		}
		return result;
	}

}
