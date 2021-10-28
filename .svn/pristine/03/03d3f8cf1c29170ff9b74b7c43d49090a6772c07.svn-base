package com.llynx.modules.fr.ma;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.llynx.modules.fr.fr.FRFR01_Mapper;
//import com.llynx.pom.monitor.MonitoringMapper;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@RemoteProxy(name="FRMA01_Service")
public class FRMA01_Service extends EgovAbstractServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(FRMA01_Service.class);

	//@Autowired
	//private MonitoringMapper monitoringMapper;

	@Autowired
	private FRFR01_Mapper frfr01Mapper;

	/**
	 * 캠페인 상담원 모니터링 데이터
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	@RemoteMethod
	public Map<String, Object> getCampAgentMnData() throws SQLException{
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result = frfr01Mapper.getIntroAgentMonData();
			result.put("result", "S");
		} catch(Exception e) {
			result.put("result", "F");
			logger.error(e.getMessage());
		}
		return result;
	}

	@RemoteMethod
	public Map<String, Object> getIntroCampMonData(Map<String, Object> param) throws SQLException {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			//List<Map<String, Object>> list = monitoringMapper.getIntroCampMonData();
			List<Map<String, Object>> list = null;
			result.put("list", list);
			result.put("result", "S");
		} catch (Exception e) {
			result.put("result", "F");
			result.put("msg", "인트로캠페인 모니터링 정보를 가져오는 중 오류가 발생하였습니다.");
			logger.error(e.getMessage());
		}
		return result;
	}
}
