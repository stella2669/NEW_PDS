package com.llynx.modules.mn.cm;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

//import com.llynx.pom.monitor.MonitoringMapper;

@RemoteProxy(name="MNCM01_Service")
public class MNCM01_Service {

	private static final Logger logger = LoggerFactory.getLogger(MNCM01_Service.class);

	//@Autowired
	//private MonitoringMapper monitoringMapper;

	@Autowired
	private MNCM01_Mapper mncm01Mapper;

	/**
	 * 캠페인 모니터링 리스트 호출
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	@RemoteMethod
	public Map<String, Object> getCampMonList(Map<String, Object> param) throws SQLException{
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			// 조회전 데이터 업데이트
			//List<Map<String, Object>> pomData = monitoringMapper.getCampMonData(param);
			//ist<Map<String, Object>> pomData = monitoringMapper.getCampMonData(param);
//			for(int i=0;i<pomData.size();i++) {
//				mncm01Mapper.refreshMonData(pomData.get(i));
//			}
//
//			List<Map<String, Object>> list = mncm01Mapper.getCampMonList();
			result.put("result", "S");
			result.put("list", "");
		} catch(Exception e) {
			result.put("result", "F");
			logger.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 캠페인 상담원 모니터링 데이터
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	@RemoteMethod
	public Map<String, Object> getCampAgentMnData(Map<String, Object> param) throws SQLException{
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result = mncm01Mapper.getCampAgentMnData(param);
			result.put("result", "S");
		} catch(Exception e) {
			result.put("result", "F");
			logger.error(e.getMessage());
		}
		return result;
	}

}
