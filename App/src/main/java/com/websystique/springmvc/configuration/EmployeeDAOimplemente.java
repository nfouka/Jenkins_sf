package com.websystique.springmvc.configuration;

import java.util.List;


import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.EmployeeDaoInterface;

public class EmployeeDAOimplemente implements EmployeeDaoInterface {


	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		// TODO Auto-generated method stub
		return false;
	}

}
