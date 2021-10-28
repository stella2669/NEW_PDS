package com.llynx.modules.cu.nc;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface CUNC01_Mapper {
	
	/**
	 * DNC리스트 카운트
	 * @Method : getTotalCount
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */
	public int getTotalCount(Map<String, Object> paramMap);
	
	/**
	 * DNC리스트 조회
	 * @Method : getDncList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	public List<Map<String, Object>> getDncList(Map<String, Object> paramMap);
	
	/**
	 * DNC 중복조회
	 * @Method : dupCheckDnc
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	public boolean dupCheckDnc(Map<String, Object> paramMap);
	
	/**
	 * DNC 저장
	 * @Method : insertDnc
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */		
	public void insertDnc(Map<String, Object> paramMap);
	
	/**
	 * DNC 수정
	 * @Method : updateDnc
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */		
	public void updateDnc(Map<String, Object> paramMap);
	
	
	/**
	 * DNC 삭제
	 * @Method : deleteDnc
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */		
	public void deleteDnc(Map<String, Object> paramMap);		
}
