package org.dciss.db;

import java.sql.*;
import java.util.LinkedList;

public class DdConnnection {

   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/symfony";
   static final String USER = "root";
   static final String PASS = "";
   
   private String sql  ; 

   public String getSql() {
	return sql;
}


public DdConnnection() {
	super();
}


public void setSql(String sql) {
	this.sql = sql;
}

public Connection getConnection() throws SQLException{
	 Connection conn = null;
	 try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	return conn ; 
}


public LinkedList<Student> executeQuery(){
	
	LinkedList<Student> list = new LinkedList<>()  ; 
	Connection conn = null;
	Statement stmt = null;

	  try{
	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery(this.getSql());

	      //STEP 5: Extract data from result set
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
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	return list  ; 
	
}

public DdConnnection(String sql) {
	super();
	this.sql = sql;
	
}





public static void main(String[] args) {
	LinkedList<Student> list = new DdConnnection("SELECT * FROM `employees` ").executeQuery() ; 
	
}


}