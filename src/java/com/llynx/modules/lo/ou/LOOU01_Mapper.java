package com.llynx.modules.lo.ou;

import java.util.HashMap;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface LOOU01_Mapper {
	
	public int updateLogoutInfo(HashMap<String,Object> param);
}
