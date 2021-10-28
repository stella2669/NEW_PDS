package com.llynx.modules.mn.cm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface MNCM01_Mapper {
	/**
	 * 캠페인 모니터링 리스트 호출
	 * @return
	 * @throws SQLException
	 */
	List<Map<String,Object>> getCampMonList() throws SQLException;

	/**
	 * 캠페인 모니터링 리스트 호출
	 * @return
	 * @throws SQLException
	 */
	List<Map<String,Object>> getThisWeekData(Map<String, Object> param) throws SQLException;

	/**
	 * 캠페인 상담원 모니터링 데이터
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	Map<String, Object> getCampAgentMnData(Map<String, Object> param) throws SQLException;

	/**
	 * 캠페인 모니터링데이터 insert
	 * @throws SQLException
	 */
	void refreshMonData(Map<String, Object> param) throws SQLException;
}
