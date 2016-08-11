package com.websystique.springmvc.model;


public class Entreprise {
	private String name ; 
	private Employee employees ;
	
	public Employee getEmployees() {
		return employees;
	}
	public void setEmployees(Employee employees) {
		this.employees = employees;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Entreprise [name=" + name + ", employees=" + employees.toString() + "]";
	} 
	
	
}
