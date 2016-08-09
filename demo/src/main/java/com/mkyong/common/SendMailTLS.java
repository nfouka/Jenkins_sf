package com.mkyong.common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMailTLS {
	
	
	private String username ; 
	private String password ; 
	private String to ; 
	private String from ; 
	private String message  ; 
	
	
	public SendMailTLS(String username, String password, String to, String from , String message) {
		
		super();
		this.username = username;
		this.password = password;
		this.to = to;
		this.from = from;
		this.message = message ; 
	}

	public void send(){
		

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject("Testing Subject");
			message.setText(this.message);

			Transport.send(message);

			System.out.println("++++++++  ++++++++ \t ++++++++ ++++++++ ");
			System.out.println("\tmail has been send from " + this.from + " , to " + this.to);
			System.out.println("++++++++  ++++++++ \t ++++++++ ++++++++ ");
			
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}