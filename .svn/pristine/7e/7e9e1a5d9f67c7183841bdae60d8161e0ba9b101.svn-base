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
package com.llynx.cmn.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Class Name : FileUpLoad.java
 * @Description : FileUpLoad Class
 * @author user
 * @since 2020-07-28
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2021-01-11  ybLee         최초생성
 *
 *</pre>
 */
public class FileUpLoad {
	
    private static final Logger logger = LoggerFactory.getLogger(FileUpLoad.class);
	
	//파일 업로드시
	public static Map<String,Object> fileUpload(MultipartFile fileData, String path, Map<String,Object> param) throws IOException {
		
		logger.debug("uploadFile==>{}", fileData.getOriginalFilename());
		
		// 저장할 파일명을 변경
		Calendar cal= Calendar.getInstance();
	    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String today = df.format(cal.getTime());
		String filePath = path+"/"+today;
		String sysFileNm = UUID.randomUUID().toString();
		String oriFileNm = fileData.getOriginalFilename();
				
		if ( oriFileNm != null ) {
		    if( !oriFileNm.endsWith(".bat") || !oriFileNm.endsWith(".sh") || !oriFileNm.endsWith(".cmd")
		    		|| !oriFileNm.endsWith(".exe") || !oriFileNm.endsWith(".dll")
		    		|| !oriFileNm.endsWith(".js") || !oriFileNm.endsWith(".jsp") || !oriFileNm.endsWith(".html")) {
		    	
				long fileSize = fileData.getSize();
		
				InputStream is = null;
				OutputStream out = null;
		
				try {
					if (fileSize > 0) {
						is = fileData.getInputStream();
						File realUploadDir = new File(filePath);
						
						if (!realUploadDir.exists()) {             
							//경로에 폴더가 존재하지 않으면 생성합니다.
							realUploadDir.mkdirs();
						}
		
						out = new FileOutputStream(filePath +"/"+ sysFileNm);
						FileCopyUtils.copy(is, out);            //InputStream에서 온 파일을 outputStream으로 복사
						
						param.put("filePath", filePath);
						param.put("sysFileNm", sysFileNm);
						param.put("oriFileNm", oriFileNm);
					}else{
						new IOException("잘못된 파일을 업로드 하셨습니다.");
					}
				} catch (IOException e) {
					new IOException("파일 업로드에 실패하였습니다.");
				}finally{
					if(out != null){out.close();}
					if(is != null){is.close();}
				}
		    }
		}		
		return param;
	}
}