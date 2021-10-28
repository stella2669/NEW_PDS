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
package com.llynx.cmn.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

import com.llynx.cmn.util.DateTimeUtil;

/**
 * @Class Name : CommandMap.java
 * @Description : CommandMap Class
 * @author user
 * @since 2020-07-28
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-07-28  user         최초생성
 * @ 2020-07-29  이윤배               공통코드관리 페이지 샘플 작업
 * @ 2020-07-30  이윤배               공통코드관리 페이지 샘플 작업
 *
 *</pre>
 */
public class CommandMap {
   Map<String,Object> map = new HashMap<String,Object>();
    
   public Object get(String key){
       return map.get(key);
   }
   
   public String getString(String key,String ifNullValue){
	   if (containsKey(key)) {
		   return ((String) map.get(key)).equals("") ? ifNullValue : (String) map.get(key);
	   }else {
		   return ifNullValue;
	   }
   }
    
   public void put(String key, Object value){
       map.put(key, value);
   }
   
   /**
    * @param 
    * @return String
    */
   public String getStringCurentData()throws Exception{  
 	  return DateTimeUtil.getDate("yyyyMMddHHmmss");
   }
   
   public Object remove(String key){
       return map.remove(key);
   }
    
   public boolean containsKey(String key){
       return map.containsKey(key);
   }
    
   public boolean containsValue(Object value){
       return map.containsValue(value);
   }
    
   public void clear(){
       map.clear();
   }
    
   public Set<Entry<String, Object>> entrySet(){
       return map.entrySet();
   }
    
   public Set<String> keySet(){
       return map.keySet();
   }
    
   public boolean isEmpty(){
       return map.isEmpty();
   }
    
   public void putAll(Map<? extends String, ?extends Object> m){
       map.putAll(m);
   }
    
   public Map<String,Object> getMap(){
       return map;
   }
}
