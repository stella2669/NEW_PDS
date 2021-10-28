package com.llynx.modules.cp.em;

import java.util.HashMap;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


/**
 * @Class Name : CPEM01_Service.java
 * @Description : CPEM01_Service Class
 * @author ybLee
 * @since 2021-04-28
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021-04-28  ybLee     최초생성
 *
 *</pre>
 */

@RemoteProxy(name="CPEM01_Service")
public class CPEM01_Service extends EgovAbstractServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(CPEM01_Service.class);
	
	@Autowired
	private CPEM01_Mapper cpem01Mapper;
	
	/**
	 * 캠페인 수정
	 * @Method : updateCamp
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> campStateUpdate(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cpem01Mapper.campStateUpdate(paramMap);
			result.put("result", "S");			
		} catch(NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "캠페인 수정 도중 오류가 발생하였습니다.");
			logger.error(npe.getMessage());			
		} catch(Exception e){
			result.put("result", "F");
			result.put("msg", "캠페인 수정 도중 오류가 발생하였습니다.");
			logger.error(e.getMessage());
		}
		return result;
	}		

}
