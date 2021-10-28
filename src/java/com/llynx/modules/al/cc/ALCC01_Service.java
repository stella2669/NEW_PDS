package com.llynx.modules.al.cc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RemoteProxy(name="ALCC01_Service")
public class ALCC01_Service {
	private static final Logger logger = LoggerFactory.getLogger(ALCC01_Service.class);

	@Autowired
	private ALCC01_Mapper alcc01Mapper;

	public List<Map<String, Object>> getCampCompCodeStaticsData(Map<String, Object> param) throws SQLException{
		return alcc01Mapper.getCampCompCodeStaticsData(param);
	}

	public List<Map<String, Object>> getCampListByDate(Map<String, Object> param) throws SQLException{
		return alcc01Mapper.getCampListByDate(param);
	}
}
