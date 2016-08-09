package net.viralpatel.spring.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.core.env.Environment;


import net.viralpatel.spring.model.Student;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.viralpatel.spring")
@PropertySource(value="classpath:config.properties" ,ignoreResourceNotFound=true)

public class AppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment env;
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Bean(name="hello")
	@Description("desciprtion")
	public Student getStudentInstance(){
		System.out.println("prop:"+env.getProperty("mongodb.url"));
		return new Student() ; 
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}