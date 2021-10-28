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
package com.llynx.cmn.auth;

/**
 * @Class Name : AccessDeninedException.java
 * @Description : AccessDeninedException Class
 * @author USER
 * @since 2020-10-30
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-10-30  USER         최초생성
 *
 *</pre>
 */
public class AccessDeninedException extends Throwable {
	private static final long serialVersionUID = -7894490052350471290L;
	
	public AccessDeninedException() {
		super("접근 권한이 없습니다.\n권한 확인후 다시 시도하세요.");
	}

	public AccessDeninedException(String message) {
		super(message);
	}
}
