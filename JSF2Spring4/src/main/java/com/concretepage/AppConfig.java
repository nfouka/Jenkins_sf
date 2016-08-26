package com.concretepage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.concretepage")
public class AppConfig {
   @Bean	
   public StudentService studentService(){
	   return new StudentServiceImpl();
   }
}
