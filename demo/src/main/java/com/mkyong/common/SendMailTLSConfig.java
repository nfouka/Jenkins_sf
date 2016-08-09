package com.mkyong.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class SendMailTLSConfig {
		@Bean(name="sendMailer")
		@Description("SEND MAIL FROM SPING CONFIGURATION.")
		public SendMailTLS newInstanceSendMail(){
			return 	new SendMailTLS(
					"mail@gmail.com", 
					"password"
					,"nadir.fouka@gmail.com", 
					"no_replay@edu.uk", 
					"hello nadir "
					) ; 
		}
}
