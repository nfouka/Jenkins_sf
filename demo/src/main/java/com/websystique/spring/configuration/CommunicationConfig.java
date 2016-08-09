package com.websystique.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Import;

import com.websystique.spring.Communication;

@Configuration
@Import({ ActiveMQMessagingConfig.class, RSAEncryptionConfig.class })
public class CommunicationConfig {
@Bean(name="communication")
@Description("description")
public Communication getInstanceCommunation(){
	Communication communication = new Communication(new RSAEncryptionConfig().getInstanceRSAEncryption()) ;
	communication.setMessaging(new ActiveMQMessagingConfig().getInstanceRSAEncryptionActivate());
	return communication; 
}


}
