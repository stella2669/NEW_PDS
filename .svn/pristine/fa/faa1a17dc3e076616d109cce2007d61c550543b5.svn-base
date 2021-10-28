package com.llynx.modules.cp.cm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.llynx.cmn.services.paging.PagingService;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


/**
 * @Class Name : CPCM01_Service.java
 * @Description : CPCM01_Service Class
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

@RemoteProxy(name="CPCM01_Service")
public class CPCM01_Service extends EgovAbstractServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(CPCM01_Service.class);
	
	@Autowired
	private CPCM01_Mapper cpcm01Mapper;
	
	/**
	 * 데이터리스트 SelectBox
	 */
	public List<Map<String, Object>> getDataList() throws Exception{
		return cpcm01Mapper.getDataList();
	}
	
	
	/**
	 * 캠페인 리스트 조회
	 * @Method : getCampList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> getCampList(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String, Object>> list = null;
		try {
			int totalCount = cpcm01Mapper.getTotalCount(paramMap);
			paramMap.put("totalCount", totalCount);
			PagingService ps = new PagingService();
			Map<String, Object> pagingMap = ps.getPaging(paramMap);
			
			if(totalCount>0) {
				list = cpcm01Mapper.getCampList(pagingMap);
			}
			
			result.put("result", "S");
			result.put("list",list);			
			result.put("paging",pagingMap);			
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "캠페인 리스트를 가져오는데 실패하였습니다.");
			logger.error(npe.getMessage());
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "캠페인 리스트를 가져오는데 실패하였습니다.");
			logger.error(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 캠페인 저장
	 * @Method : insertCamp
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> insertCamp(Map<String, Object> paramMap, List<Map<String,Object>> campCustList){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cpcm01Mapper.insertCamp(paramMap);
			System.out.println(paramMap);
			if(campCustList!=null&&campCustList.size()>0) {
				paramMap.put("list", campCustList);
				cpcm01Mapper.insertCampCust(paramMap);
			}
			result.put("result", "S");			
		} catch(NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "캠페인 저장 도중 오류가 발생하였습니다.");
			logger.error(npe.getMessage());			
		} catch(Exception e){
			result.put("result", "F");
			result.put("msg", "캠페인 저장 도중 오류가 발생하였습니다.");
			logger.error(e.getMessage());
		}
		return result;
	}	

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
	public Map<String,Object> updateCamp(Map<String, Object> paramMap, List<Map<String,Object>> campCustList){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cpcm01Mapper.updateCamp(paramMap);
			if(campCustList!=null&&campCustList.size()>0) {
				paramMap.put("list", campCustList);
				cpcm01Mapper.insertCampCust(paramMap);
			}
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

	/**
	 * 캠페인 삭제
	 * @Method : deleteCamp
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	@RemoteMethod
	public Map<String,Object> deleteCamp(Map<String, Object> paramMap){	
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			cpcm01Mapper.deleteCamp(paramMap);
			result.put("result", "S");			
		} catch(NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "캠페인 삭제 도중 오류가 발생하였습니다.");
			logger.error(npe.getMessage());			
		} catch(Exception e){
			result.put("result", "F");
			result.put("msg", "캠페인 삭제 도중 오류가 발생하였습니다.");
			logger.error(e.getMessage());
		}
		return result;
	}
	

	/**
	 * 고객데이터 추출
	 * @Method : getSearchCust
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */
	@RemoteMethod
	public Map<String,Object> getSearchCust(Map<String, Object> paramMap) {
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			List<Map<String, Object>> list = cpcm01Mapper.getSearchCust(paramMap);
			
			result.put("result", "S");
			result.put("list",list);		
		} catch (NullPointerException npe) {
			result.put("result", "F");
			result.put("msg", "고객데이터를 추출하는데 실패하였습니다.");
			logger.error(npe.getMessage());
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "고객데이터를 추출하는데 실패하였습니다.");
			logger.error(e.getMessage());
		}
		return result;
	}
}
