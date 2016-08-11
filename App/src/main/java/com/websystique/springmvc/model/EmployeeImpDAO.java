package com.websystique.springmvc.model;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeImpDAO implements EmployeeDaoInterface {
	
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session open = sessionFactory.openSession() ; 
		open.persist(employee);
		open.flush();
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
		
		Session open = sessionFactory.openSession() ; 
		List<Employee> personsList = sessionFactory.openSession().createSQLQuery("select * from EMPLOYEE").list() ; 
		for(Employee e:personsList){
			System.out.println(e);
		}
		
		return personsList ; 

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
