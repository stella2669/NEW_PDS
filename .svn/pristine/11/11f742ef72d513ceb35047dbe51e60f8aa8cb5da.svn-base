package com.llynx.modules.al.ca;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RemoteProxy(name="ALCA01_Service")
public class ALCA01_Service {
	private static final Logger logger = LoggerFactory.getLogger(ALCA01_Service.class);

	@Autowired
	private ALCA01_Mapper alca01Mapper;

	public List<Map<String, Object>> getCampStaticsData(Map<String, Object> param) throws SQLException{
		return alca01Mapper.getCampStaticsData(param);
	}
}
