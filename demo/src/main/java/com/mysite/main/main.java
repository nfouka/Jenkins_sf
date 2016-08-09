package com.mysite.main;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.DemoApplication;
import com.mkyong.common.SendMailTLS;
import com.mkyong.config.AppConfig;

public class main {

	private static AnnotationConfigApplicationContext ctx;
	
public static void main(String[] args) throws Exception {
	SpringApplication.run(DemoApplication.class, args);
	ctx = new AnnotationConfigApplicationContext();
	ctx.register(AppConfig.class);
	ctx.refresh();
	SendMailTLS c = (SendMailTLS) ctx.getBean("sendMailer") ; 
	c.send();
}


	
}
