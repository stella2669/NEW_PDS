package com.llynx.modules.us.hi;

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
 * @Class Name : USHI01_Service.java
 * @Description : USHI01_Service Class
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
@RemoteProxy(name="USHI01_Service")
public class USHI01_Service {
	private static final Logger logger = LoggerFactory.getLogger(USHI01_Service.class);
	
	@Autowired
	private USHI01_Mapper ushi01_Mapper;
	
	
	@RemoteMethod
	public Map<String,Object> getAgtLogOut(Map<String, Object> paramMap) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>(); 
		try {
			List<Map<String, Object>> list = ushi01_Mapper.getAgtLogOut(paramMap);
			result.put("result", "S");
			result.put("list",list);			
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "사용자 로그를 가져오는데 실패하였습니다,");
			logger.error(npe.getMessage()); 
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "사용자 로그를 가져오는데 실패하였습니다,");
			logger.error(e.getMessage());
		}
		return result;
	}
	
}
