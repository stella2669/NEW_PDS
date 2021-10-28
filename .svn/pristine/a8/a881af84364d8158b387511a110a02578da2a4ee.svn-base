package com.llynx.modules.al.cc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface ALCC01_Mapper {

	/**
	 * 캠페인 완료코드 통계 캠페인리스트 그룹 데이터
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	List<Map<String, Object>> getCampListByDate(Map<String, Object> param) throws SQLException;

	/**
	 * 캠페인 완료코드 통계페이지 데이터
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	List<Map<String, Object>> getCampCompCodeStaticsData(Map<String, Object> param) throws SQLException;

	/**
	 * 캠페인 완료코드 통계데이터 배치 인서트
	 * @param param
	 */
	void insertCampCompCodeStaticsData(Map<String, Object> param) throws SQLException;
}
