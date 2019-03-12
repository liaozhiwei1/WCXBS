package com.wcx.server;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.log4j.helpers.ThreadLocalMap;

public class email {
	public void fun(String str) throws AddressException, MessagingException{
		Properties  prop = new Properties();
		prop.setProperty("mail.transport.protocol", "SMTP");
		prop.setProperty("mail.host", "smtp.qq.com");
		prop.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("1163230808@qq.com", "btuaxhukouudhcdf");
			}
		};
		Session session = Session.getInstance(prop, auth);
		
		Message message = new  MimeMessage(session);
		message.setFrom(new InternetAddress("1163230808@qq.com"));
		message.setRecipient(RecipientType.TO, new InternetAddress("1163230808@QQ.com")); // 设置发送方式与接收者

		message.setSubject("传感器提示");

		message.setContent(str, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送

		Transport.send(message);
		System.out.println("已发送");
	}
}
