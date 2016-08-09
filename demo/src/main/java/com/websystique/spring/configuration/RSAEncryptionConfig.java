package com.websystique.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import com.websystique.spring.domain.impl.RSAEncryption;


@Configuration
public class RSAEncryptionConfig {
		@Bean(name="rsa")
		@Description("description activae")
		public RSAEncryption getInstanceRSAEncryption(){
			return new RSAEncryption() ; 
		}
	
}
