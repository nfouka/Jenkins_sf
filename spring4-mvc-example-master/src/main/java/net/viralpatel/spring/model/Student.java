package net.viralpatel.spring.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;


@PropertySources({
	@PropertySource(value="classpath:config.properties" , ignoreResourceNotFound=false),
	
})
public class Student {
	
	
	@Autowired
	private Environment env;
	
	
		public String sayHello(){
			return "Hello World ." + env.getProperty("database_driver")    ; 
}
}