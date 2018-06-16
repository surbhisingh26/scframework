package com.social.scframework.App;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;

import com.social.scframework.App.Utility;

public class Email {
	Utility utility = new Utility();
	public void send(String recieverName,String recieverEmail,String subject,String template,String templatePath,Map<String,Object> hashMap) throws ServletException, IOException{  
		//Get properties object  
		System.out.println("send email ");
		final String from = "surbhi.singh.ss05@gmail.com";
		final String password="as192118020809";
		Properties props = new Properties();    
		props.put("mail.smtp.host", "smtp.gmail.com");    
		props.put("mail.smtp.socketFactory.port", "465");    
		props.put("mail.smtp.socketFactory.class",    
				"javax.net.ssl.SSLSocketFactory");    
		props.put("mail.smtp.auth", "true");    
		props.put("mail.smtp.port", "465");    
		//get Session   
		
		Session session = Session.getDefaultInstance(props,    
				new javax.mail.Authenticator() {    
			protected PasswordAuthentication getPasswordAuthentication() {    
				return new PasswordAuthentication(from,password);  
			}    
		});    
		//compose message   
		
		try {    
			MimeMessage message = new MimeMessage(session);    
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(recieverEmail));    
			message.setSubject(subject);   
			String text = utility.getHbsAsString(template,hashMap,templatePath);
			message.setContent(text,"text/html");
			//send message  
			
			Transport.send(message);    
			System.out.println("message sent successfully");    
		}
		catch (MessagingException e) {throw new RuntimeException(e);}    

	}  
}
