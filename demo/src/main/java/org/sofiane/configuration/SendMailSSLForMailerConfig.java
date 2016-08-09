package org.sofiane.configuration;

import org.sofiane.SendMailSSLForMailer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class SendMailSSLForMailerConfig {
	
	@Bean(name="SendMailSSLForMailerConfigBeans")
	@Description("un beans qui map la classe")
	
	public SendMailSSLForMailer getInstanceSendMailSSLForMailer(){
		return new SendMailSSLForMailer(
				"mail","password",
				"mail@gmail.com", 
				"abdel.kellal@gmail.com", 
				"subject", 
				"salut sofinae ") ; 
	}

}
