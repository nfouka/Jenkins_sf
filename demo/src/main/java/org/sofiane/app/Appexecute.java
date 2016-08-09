package org.sofiane.app ;

import org.sofiane.SendMailSSLForMailer;
import org.sofiane.configuration.SendMailSSLForMailerConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Appexecute {

	public static void main(String[] args) {
		
	
		ApplicationContext ctx =  new AnnotationConfigApplicationContext(SendMailSSLForMailerConfig.class);   
		SendMailSSLForMailer mailer = (SendMailSSLForMailer) ctx.getBean("SendMailSSLForMailerConfigBeans");
		mailer.send();
	}


}
