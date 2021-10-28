package com.llynx.modules.common;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface Common_Mapper {

	/**
	 * 상세코드(공통코드) 리스트
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> getComCdList(String param) throws Exception;

	/**
	 * 권한코드 리스트
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> getAuthList() throws Exception;

	/**
	 * 그룹코드 리스트
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> getGroupList() throws Exception;

	/**
	 * 프로그램코드 리스트
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> getProgCdList() throws Exception;

	/**
	 * 완료코드 리스트
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> getCompleteCodes(Map<String,Object> param) throws Exception;

	/**
	 * 상담원 리스트
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<Map<String,Object>> getEmpList(Map<String,Object> param) throws Exception;

	void syncPomCompleteCodes(Map<String,Object> param) throws Exception;
	void compCodeTempInsert(Map<String,Object> param) throws Exception;
	void deleteCompCodes(String id) throws Exception;
	void updateStaticsYnCode(Map<String,Object> param) throws Exception;

}
