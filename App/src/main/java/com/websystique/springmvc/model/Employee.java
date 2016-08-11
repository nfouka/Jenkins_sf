package com.websystique.springmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
 

 
@Entity
@Table(name="EMPLOYEE")
public class Employee {
 
	@Id
    private int id;
 
    @Size(min=0, max=50)
    @Column(name = "NAME", nullable = true)
    private String name;


    @Column(name = "JOINING_DATE", nullable = true)
    private Date joiningDate;
 

    @Digits(integer=8, fraction=2)
    @Column(name = "SALARY", nullable = true)
    private int salary;
     
    @Column(name = "SSN", unique=true, nullable = true )
    private String ssn;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Date getJoiningDate() {
        return joiningDate;
    }
 
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
 
    public int getSalary() {
        return salary;
    }
 
    public void setSalary(int salary) {
        this.salary = salary;
    }
 
    public String getSsn() {
        return ssn;
    }
 
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        if (ssn == null) {
            if (other.ssn != null)
                return false;
        } else if (!ssn.equals(other.ssn))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", joiningDate="
                + joiningDate + ", salary=" + salary + ", ssn=" + ssn + "]";
    }

	public Employee( String name, Date joiningDate, int salary, String ssn) {
		super();
		this.id = 9999 ; 
		this.name = name;
		this.joiningDate = joiningDate;
		this.salary = salary;
		this.ssn = ssn;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
     
    
}