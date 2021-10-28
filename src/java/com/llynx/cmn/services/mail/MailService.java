package com.llynx.cmn.services.mail;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;


@Service
public class MailService {
	
	private static final Logger logger = LoggerFactory.getLogger(MailService.class);
	
	@Autowired
	JavaMailSenderImpl mailSender;

	@Resource(name="appProp")
	private Properties prop;
	
	public void sendMail(Map<String,Object> param, MultipartFile attachedFile) throws MessagingException, IOException {
		MimeMessage message = mailSender.createMimeMessage();

		message.setFrom("llynxtech");
		message.addRecipients( RecipientType.TO, param.get("to").toString());
		message.setSubject(param.get("title").toString());
		message.setText(param.get("contents").toString());

		
		if(!attachedFile.isEmpty()) {

            BodyPart bodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            
			String tempPath = "C:/workspace/data/files/mail";
			
			
			File target =new File(tempPath, attachedFile.getOriginalFilename());
			
			FileCopyUtils.copy(attachedFile.getBytes(), target);
		
			//서버에 저장 된 파일을 보낸다. 
			DataSource dataSource =new FileDataSource(tempPath +"/"+ attachedFile.getOriginalFilename());	

            bodyPart.setDataHandler(new DataHandler(dataSource));
            bodyPart.setFileName(MimeUtility.encodeText(attachedFile.getOriginalFilename(), "utf-8", "B"));
            
            multipart.addBodyPart(bodyPart);
            message.setContent(multipart, "text/html; charset=UTF-8");
			//메일 보내기
			mailSender.send(message);
	
			//서버에 저장된 파일을 삭제 한다.
			File file = new File(tempPath +"/"+ attachedFile.getOriginalFilename());
			if(file.exists()){
				file.delete();
				logger.debug("첨부 파일 삭제 완료");
			}
		}else {
			mailSender.send(message);			
		}
		
	}
	
}
