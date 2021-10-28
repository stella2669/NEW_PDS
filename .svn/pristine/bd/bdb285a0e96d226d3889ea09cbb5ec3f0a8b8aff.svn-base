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

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Class Name : ApplicationContextProvider.java
 * @Description : ApplicationContextProvider Class
 * @author felix.kim
 * @since 2020-09-14
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-09-14  felix.kim         최초생성
 *
 *</pre>
 */
public class ApplicationContextProvider implements ApplicationContextAware {
	
	private static ApplicationContext ctx;
	
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
	
	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext ctx) {
		this.ctx = ctx;
	}

}
