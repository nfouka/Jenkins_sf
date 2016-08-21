package com.concretepage;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.concretepage")
public class StudentImpDAOConf {
	
 	@Autowired
 	DataSource dataSource ; 
	

	@Bean
	public StudentImpDAO getStudentImpDAOiNSTANCE(){
		return new StudentImpDAO(this.getDataSource()) ; 
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
