package com.websystique.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import com.websystique.spring.domain.impl.ActiveMQMessaging;

@Configuration
public class ActiveMQMessagingConfig {
	@Bean(name="activate")
	@Description("description activae")
	public ActiveMQMessaging getInstanceRSAEncryptionActivate(){
		return new ActiveMQMessaging() ; 
	}
}
