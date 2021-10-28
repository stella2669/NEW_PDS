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
package com.llynx.cmn.dao;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Class Name : AbstractDao.java
 * @Description : AbstractDao Class
 * @author user
 * @since 2020-07-28
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-07-28  user         최초생성
 *
 *</pre>
 */
public class AbstractDao {
	private static final Logger logger = LoggerFactory.getLogger(AbstractDao.class);
	
	@Autowired
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	protected void printQueryId(String queryId) {
		if(logger.isDebugEnabled()){
			logger.debug("\t QueryId  \t:  " + queryId);
		}
	} 
	public int insert(String queryId, Object params) { 
		return sqlSession.insert(queryId, params);
	}
	public int update(String queryId, Object params) { 
		return sqlSession.update(queryId, params);
	}
	public int delete(String queryId, Object params) { 
		return sqlSession.delete(queryId, params);
	}
	public Object selectOne(String queryId) {
		return sqlSession.selectOne(queryId);
	}
	public Object selectOne(String queryId, Object params) {
		return sqlSession.selectOne(queryId, params);
	}
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId) {
		return sqlSession.selectList(queryId);
	}
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId, Object params) {
		return sqlSession.selectList(queryId,params);
	}
}
