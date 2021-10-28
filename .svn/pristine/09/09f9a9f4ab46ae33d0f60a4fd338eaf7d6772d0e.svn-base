package com.llynx.modules.mn.sm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface MNSM01_Mapper {
	/**
	 * 캠페인 상담원 모니터링 리스트 호출
	 * @return
	 * @throws SQLException
	 */
	List<Map<String,Object>> getCampAgentList(Map<String, Object> param) throws SQLException;

	void refreshAgentMonData(Map<String, Object> param) throws SQLException;
	
	/**
	 * 카프카 이벤트 저장
	 * type : agentEventType
	 * @param param
	 * @throws SQLException
	 */
	void insertAgentEvent01(Map<String, Object> param) throws SQLException;
}
