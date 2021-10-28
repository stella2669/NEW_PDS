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
package com.llynx.cmn.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Class Name : MybatisTypeHandler.java
 * @Description : MybatisTypeHandler Class
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
@SuppressWarnings("rawtypes")
public class MybatisTypeHandler implements TypeHandler {
    private static final Logger logger = LoggerFactory.getLogger(MybatisTypeHandler.class);
	
	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.TypeHandler#setParameter(java.sql.PreparedStatement, int, java.lang.Object, org.apache.ibatis.type.JdbcType)
	 */
	@Override
	public void setParameter(PreparedStatement arg0, int arg1, Object arg2, JdbcType arg3) throws SQLException {		
		try {
			arg0.setString(arg1, (String)arg2);
			//arg0.setString(arg1, crypto.encrypt((String)arg2));
		} catch (Exception e) {
			logger.error("", e);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, java.lang.String)
	 */
	@Override
	public Object getResult(ResultSet arg0, String arg1) throws SQLException {
		return arg0.getString(arg1);
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, int)
	 */
	@Override
	public Object getResult(ResultSet arg0, int arg1) throws SQLException {
		return arg0.getString(arg1);
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.CallableStatement, int)
	 */
	@Override
	public Object getResult(CallableStatement arg0, int arg1) throws SQLException {
		return arg0.getString(arg1);
	}
}
