package com.journaldev.springhibernate.service;

import java.util.List;

import org.hibernate.SessionFactory;

public class Student {
	
	  private SessionFactory sessionFactory;

		public Student(SessionFactory sessionFactory) {
			super();
			this.sessionFactory = sessionFactory;
		}



		public void sayHello(){
			System.out.println("List all students") ; 
		}
		
}
