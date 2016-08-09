package org.sofiane ; 

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMailSSLForMailer  {
	
		private String username ;   
		private String password ; 
		private String form 	; 
		private String to       ; 
		private String subject ; 
		private String msg     ; 
		
		
	
	
	public SendMailSSLForMailer(String username, String password, String form, String to, String subject,
				String msg) {
			super();
			this.username = username;
			this.password = password;
			this.form = form;
			this.to = to;
			this.subject = subject;
			this.msg = msg;
		}




	public String getUsername() {
			return username;
		}




		public void setUsername(String username) {
			this.username = username;
		}




		public String getPassword() {
			return password;
		}




		public void setPassword(String password) {
			this.password = password;
		}




		public String getForm() {
			return form;
		}




		public void setForm(String form) {
			this.form = form;
		}




		public String getTo() {
			return to;
		}




		public void setTo(String to) {
			this.to = to;
		}




		public String getSubject() {
			return subject;
		}




		public void setSubject(String subject) {
			this.subject = subject;
		}




		public String getMsg() {
			return msg;
		}




		public void setMsg(String msg) {
			this.msg = msg;
		}


	
		public void send() {
			// TODO Auto-generated method stub
			
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			
			Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,password );
						}
					});

				try {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(form));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(to));
					message.setSubject(subject);
					message.setText(msg);

					Transport.send(message);

					System.out.println("Done");

				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}

			
		}

		
}