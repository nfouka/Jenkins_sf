package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private Employee employee ; 

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("say hello " + employee.toString() );
	}

	@Override
	public void getingHello() {
		// TODO Auto-generated method stub
		System.out.println("getting hello " + employee.toString() );
	}

}
