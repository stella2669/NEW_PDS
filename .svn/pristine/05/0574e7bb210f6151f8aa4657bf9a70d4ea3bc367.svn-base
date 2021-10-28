/*
 * Copyright 2019 LLYNX TECH All right reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.llynx.cmn.util;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;


/**
 * @Class Name : PatternUtil.java
 * @Description : PatternUtil Class
 * @author USER
 * @since 2020-09-04
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-09-04  USER         최초생성
 *
 *</pre>
 */
public class PatternUtil {
	
	public static String setMaskStr(Object v, String p) {		
		if (ObjectUtils.defaultIfNull(v, StringUtils.EMPTY).toString().isEmpty()) {
			return "";
		}
		
		String value = (String)v;
		int size = 0;
		int idx = 0;
		String prefix = "";
		String suffix = "";
		
		switch(p) {
			case "NAME" :
				size = value.length();
				
				if (2<size) {
					prefix = value.substring(0, 1);
					suffix = value.substring(size-1, size);
					idx = size - (prefix.length()+suffix.length());
				} else if (2==size) {
					prefix = value.substring(0, 1);
					idx = size - (prefix.length()+suffix.length());
				} else {
					prefix = value;
					idx = size - (prefix.length()+suffix.length());
				}
				break;
				
			case "PRNO"	:
				value = value.replaceAll("[^0-9]", "");
				size = value.length();
				// 개발계 주민번호 오류 예외처리
				if (size>7) {
					prefix = value.substring(0,6)+"-"+value.substring(6,7);
					idx = size - (prefix.length()+suffix.length()) + 1;
				} else if (size<7) {
					prefix = value.substring(0,idx)+"-";
					idx = 7;
				} else {
					prefix = value+"-";
					idx = 7;
				}
				break;
				
			case "AREANO" :
				value = value.replaceAll("[^0-9]", "");
				size = value.length();
				
				idx = size;
				break;
				
			case "TELNO" :
				value = value.replaceAll("[^0-9]", "");
				size = value.length();
				
				prefix = value;
				idx = size - (prefix.length()+suffix.length());
				break;
				
			case "TEL" :
				value = value.replaceAll("[^0-9]", "");
				size = value.length();
				
				if(size == 11) {
					prefix = value.substring(0, 3)+"-";
					suffix = "-"+value.substring(value.length()-4, size);
					idx = size - (prefix.length()+suffix.length()) + 2;
				} else if(value.startsWith("02")) {
					if (size==9) {
						prefix = value.substring(0, 2)+"-";
						suffix = "-"+value.substring(value.length()-4, size);
						idx = size - (prefix.length()+suffix.length()) + 2;
					} else {
						prefix = value.substring(0, 2)+"-";
						suffix ="-"+ value.substring(value.length()-4, size);
						idx = size - (prefix.length()+suffix.length()) + 2;
					}
				} else if(size==10) {
					prefix = value.substring(0, 3)+"-";
					suffix = "-"+value.substring(value.length()-4, size);
					idx = size - (prefix.length()+suffix.length()) + 2;
				} else if(size>11) {
					prefix = value.substring(0, 3)+"-";
					suffix = "-"+value.substring(value.length()-4, size);
					idx = size - (prefix.length()+suffix.length()) + 2;
				} else if(size==8) {
					prefix = value.substring(0, 4)+"-";
					idx = size - (prefix.length()+suffix.length()) + 2;
				} else {
					prefix = value;
				}
				break;
				
			case "ID" :
				size = value.length();
				
				if (2<size) { 
					prefix = value.substring(0, 2);
					idx = size - (prefix.length()+suffix.length());
				} else { 
					prefix = value;
					idx = size - (prefix.length()+suffix.length());
				}
				break;
				
			case "EMAIL" :
				String[] id = value.split("@");
				size = id.length;
				
				if (1==id.length) {
					size = value.length();
					
					if (2<size) { 
						prefix = value.substring(0,2);
						idx = size - (prefix.length()+suffix.length());
					} else { 
						prefix = value;
						idx = size - (prefix.length()+suffix.length());
					}
				} else {
					value = id[0];
					size = value.length();
					
					if (2<size) { 
						prefix = value.substring(0,2);
						suffix = "@"+id[1];
						idx = size - (prefix.length()) ;
					} else { 
						prefix = value;
						suffix = "@"+id[1];
						idx = size - (prefix.length()+suffix.length()) + 1;
					}
				}
				break;
				
			case "ADDR" :
				size = value.length();
				
				idx = size - (prefix.length()+suffix.length());	
				break;
				
			default : break;	
		}

		return maksingStr(prefix, suffix, idx);
	}
	
	private static String maksingStr(String prefix, String suffix, int loop) {
		String maskChar = "";
		for (int i=0; i<loop; i++) {
			maskChar += "*";
		}
		
		return prefix+maskChar+suffix;
	}
	
}
