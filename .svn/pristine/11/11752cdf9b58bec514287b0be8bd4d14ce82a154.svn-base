package com.llynx.modules.common;

import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;


import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@RemoteProxy(name="Common_Service")
public class Common_Service extends EgovAbstractServiceImpl {

	@Autowired
	private Common_Mapper common_Mapper;

	/**
	 * 상세코드(공통코드) 리스트
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RemoteMethod
	public List<Map<String,Object>> getComCdList(String param) throws Exception{
		return common_Mapper.getComCdList(param);
	}

	@RemoteMethod
	public List<Map<String,Object>> getAuthList() throws Exception{
		return common_Mapper.getAuthList();
	}

	/**
	 * 그룹코드 리스트
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RemoteMethod
	public List<Map<String,Object>> getGroupList() throws Exception{
		return common_Mapper.getGroupList();
	}

	/**
	 * 프로그램코드 리스트
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RemoteMethod
	public List<Map<String,Object>> getProgCdList() throws Exception{
		return common_Mapper.getProgCdList();
	}

	/**
	 * 상담원 리스트
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RemoteMethod
	public List<Map<String,Object>> getEmpList(Map<String,Object> param) throws Exception{
		return common_Mapper.getEmpList(param);
	}
}
