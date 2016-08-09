package com.mkyong.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mkyong.common.SendMailTLSConfig;
import com.websystique.spring.configuration.ActiveMQMessagingConfig;
import com.websystique.spring.configuration.CommunicationConfig;
import com.websystique.spring.configuration.RSAEncryptionConfig;

@Configuration
@Import({ ActiveMQMessagingConfig.class, 
	RSAEncryptionConfig.class , 
	CommunicationConfig.class , 
	SendMailTLSConfig.class , 
})
public class AppConfig {

}