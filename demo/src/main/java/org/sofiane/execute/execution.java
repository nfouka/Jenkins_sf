package org.sofiane.execute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sofiane.SendMailSSLForMailer;
import org.sofiane.configuration.SendMailSSLForMailerConfig;

public class execution {
	
	
	private void main() {
		// TODO Auto-generated method stub

		
		ApplicationContext ctx =  new AnnotationConfigApplicationContext(SendMailSSLForMailerConfig.class);   
		SendMailSSLForMailer mailer = (SendMailSSLForMailer) ctx.getBean("SendMailSSLForMailerConfigBeans");
		mailer.send();
		
	}

	
}
