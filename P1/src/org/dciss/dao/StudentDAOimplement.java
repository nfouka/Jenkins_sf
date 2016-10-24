package org.dciss.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.dciss.model.Student;

public class StudentDAOimplement implements StudentDAO {
	
	
	@Override
	public void getStudenById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> getAllStuent() {
		// TODO Auto-generated method stub
		LinkedList<Student> list = new LinkedList<>() ; 
		try {
			Connection conn = new org.dciss.db.DdConnnection().getConnection() ;
			Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT * FROM `employees` ");
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		         
		         list.add(new Student(id, age, first, last)) ; 
		      }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return list ;
	}

	@Override
	public void removeStudent(int id) {
		// TODO Auto-generated method stub
		
	}

public static void main(String[] args) {
	List<Student> l = new StudentDAOimplement().getAllStuent() ; 
	System.out.println(l);
}

}

