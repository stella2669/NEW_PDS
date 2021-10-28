package com.llynx.modules.cp.em;

import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface CPEM01_Mapper {

	/**
	 * 캠페인 상태 수정
	 * @Method : campStateUpdate
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */		
	public void campStateUpdate(Map<String, Object> paramMap);	
	
}
