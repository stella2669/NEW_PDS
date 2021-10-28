package com.llynx.cmn.services.address;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

import com.fasterxml.jackson.databind.ObjectMapper;


@RemoteProxy(name="AddressService")
public class AddressService {
	
	@RemoteMethod
	@SuppressWarnings("unchecked")
	public Map<String,Object> searchAddress(Map<String,Object> param){
		Map<String,Object> result = null;
		try {
			String strUrl = "https://www.juso.go.kr/addrlink/addrLinkApi.do?";
			strUrl = strUrl + mapToQueryString(param);
			URL url = new URL(strUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			con.setRequestProperty("confmKey", "devU01TX0FVVEgyMDIxMDQxMzExMDkwMzExMTA0MjM%3D");
			con.setRequestMethod("GET");
			con.setDoOutput(true);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream(), Charset.forName("UTF-8")));
			
			StringBuilder sb = new StringBuilder();
			int cp;
			while((cp= bufferedReader.read()) !=-1) {
				sb.append((char)cp);
			}
			
			String jsonResult = sb.toString();
			result = new ObjectMapper().readValue(jsonResult, Map.class);			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	public String mapToQueryString(Map<String,Object> map) {
		String queryString = "";
		for(String mapKey : map.keySet()) {
			queryString += mapKey +"="+map.get(mapKey)+"&";
		}
		queryString = queryString.substring(0, queryString.length()-1);
		return queryString;
	}

}
