package com.llynx.modules.fr.me;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper
public interface FRME01_Mapper {

	/**
	 * 대분류 메뉴 조회
	 * @Method : mainMenuList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *
	 *
	 *  -------------------------------------------------
	 *
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> mainMenuList() throws Exception;
	
	/**
	 *  하위 메뉴 조회
	 * @Method : mainSubMenuList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *
	 *
	 *  -------------------------------------------------
	 *
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> mainSubMenuList(Map<String, Object> param) throws Exception;
	
	/**
	 *  하위 메뉴 조회
	 * @Method : mainSubMenuList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *
	 *
	 *  -------------------------------------------------
	 *
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> mainSubMyMenuList(Map<String, Object> param) throws Exception;
	

	/**
	 * 개인별 프로그램
	 * @Method : getProgList
	 * @author ybLee
	 * @since 2021-01-20
	 * @Description : 
	 *  -------------------------------------------------
	 * @param 
	 * @return
	 */	
	public List<Map<String, Object>> getMyMenuList(Map<String, Object> paramMap);
	
	public void insertMyMenuList(Map<String, Object> paramMap);
	public void deleteMyMenu(Map<String, Object> paramMap);
}
