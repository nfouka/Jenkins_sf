package com.mysite.model;

public class Person {
	
	private String name ; 
	private String adress ; 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	

	public Person(String name, String adress) {
		super();
		this.name = name;
		this.adress = adress;
	}

	public void sayPerson() {
		System.out.println("hello " + this.getName() );
	} 
}
