package com.llynx.modules.al.ca;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface ALCA01_Mapper {

	/**
	 * 캠페인 통계페이지 데이터
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	List<Map<String, Object>> getCampStaticsData(Map<String, Object> param) throws SQLException;

	/**
	 * 캠페인 통계데이터 배치 인서트
	 * @param param
	 */
	void insertCampStaticsData(Map<String, Object> param) throws SQLException;
}
