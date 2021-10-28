package com.llynx.modules.mn.sm;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RemoteProxy(name="MNSM01_Service")
public class MNSM01_Service {

	private static final Logger logger = LoggerFactory.getLogger(MNSM01_Service.class);

	@Autowired
	private MNSM01_Mapper mnsm01Mapper;

	/**
	 * 캠페인 모니터링 리스트 호출
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	@RemoteMethod
	public Map<String, Object> getCampAgentList(Map<String, Object> param) throws SQLException{
		Map<String, Object> result = new HashMap<String, Object>();
		try {

			List<Map<String, Object>> list = mnsm01Mapper.getCampAgentList(param);
			result.put("result", "S");
			result.put("list", list);
		} catch(Exception e) {
			result.put("result", "F");
			logger.error(e.getMessage());
		}
		return result;
	}

	public String getTimeDiffToCurr(Date statusDate) throws ParseException {
		Date curDate = new Date();
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("YYYYMMddHHmm");
		System.out.println(sdf.format(statusDate));
		long curTime = curDate.getTime();
		long statusTimes = statusDate.getTime();
		long diff = (curTime-statusTimes)/1000;
		long diffS = diff%60;
		long diffM = diff/60;
		long diffH = diff/60/60;

		String statusTime = "";

		if(diffH<10) {
			statusTime += "0"+diffH+":";
		}else {
			statusTime += diffH+":";
		}

		if(diffM<10) {
			statusTime += "0"+diffM+":";
		}else {
			statusTime += diffM+":";
		}

		if(diffS<10) {
			statusTime += "0"+diffS;
		}else {
			statusTime += diffS;
		}

		return statusTime;
	}

}
