package com.websystique.springmvc.model;

import java.util.List;

import com.websystique.springmvc.model.Employee;
 
public interface EmployeeDaoInterface {
 
    Employee findById(int id);
     
    void saveEmployee(Employee employee);
     
    void updateEmployee(Employee employee);
     
    void deleteEmployeeBySsn(String ssn);
 
    List<Employee> findAllEmployees(); 
     
    Employee findEmployeeBySsn(String ssn);
 
    boolean isEmployeeSsnUnique(Integer id, String ssn);
     
}