package com.llynx.modules.fr.me;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.llynx.cmn.services.login.LoginService;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@RemoteProxy(name="FRME01_Service")
public class FRME01_Service extends EgovAbstractServiceImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(FRME01_Service.class);
	
	@Autowired
	private FRME01_Mapper frme01_Mapper;

	@Autowired
	private LoginService session;
	
	
	@RemoteMethod
	public Map<String, Object> getMenuList() {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> menuList = new HashMap<String, Object>();

		param.put("userId", session.getUserId());

		try {
			// 메뉴정보 조회
			menuList.put("menu", frme01_Mapper.mainMenuList()); // 대분류 메뉴
			menuList.put("subMenu", frme01_Mapper.mainSubMenuList(param)); // 하위 메뉴
			menuList.put("myMenu", frme01_Mapper.mainSubMyMenuList(param)); // 하위 메뉴

			result.put("menuList", menuList);
			result.put("menuResult", true);
		} catch (DataAccessException dae) {
			logger.error("정보 조회중 오류 발생, {}", dae);

			result.put("menuResult", true);
			result.put("menuMsg", "메뉴정보 조회중 오류가 발생되었습니다.");
		} catch (Exception e) {
			logger.error("정보 조회중 오류 발생, {}", e);

			result.put("menuResult", true);
			result.put("menuMsg", "메뉴정보 조회중 오류가 발생되었습니다.");
		}
		return result;
	}
	
	@RemoteMethod
	public Map<String, Object> getMyAuthList(){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("userId", session.getUserId());
			List<Map<String, Object>> list = frme01_Mapper.getMyMenuList(param);
			result.put("result", "S");
			result.put("list", list);
		} catch (DataAccessException dae) {
			logger.error("정보 조회중 오류 발생, {}", dae);
			result.put("result", "F");
			result.put("msg", "권한정보 조회중 오류가 발생되었습니다.");
		} catch (Exception e) {
			logger.error("정보 조회중 오류 발생, {}", e);
			result.put("result", "F");
			result.put("msg", "권한정보 조회중 오류가 발생되었습니다.");
		}
		return result;
	}
		
	@RemoteMethod
	public Map<String, Object> insertMyMenuList(Map<String, Object> param, String [] progCdList){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			frme01_Mapper.deleteMyMenu(param);
			for(int i=0;i<progCdList.length;i++) {
				param.put("progCd", progCdList[i]);
				frme01_Mapper.insertMyMenuList(param);
			}
			result.put("result", "S");
		} catch (DataAccessException dae) {
			logger.error("메이메뉴 저장중 오류 발생, {}", dae);
			result.put("result", "F");
			result.put("msg", "메이메뉴 저장중 오류가 발생되었습니다.");
		} catch (Exception e) {
			logger.error("메이메뉴 저장중 오류 발생, {}", e);
			result.put("result", "F");
			result.put("msg", "메이메뉴 저장중 오류가 발생되었습니다.");
		}
		return result;
	}
}
