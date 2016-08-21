package com.concretepage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.concretepage.model.Student;
import com.sun.org.apache.xml.internal.security.Init;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class StudentImpDAO{
	
	 	@Autowired
	 	DataSource dataSource ; 
	 	
	 	 @Autowired
	     private SessionFactory sessionFactory;
	 	 

		public StudentImpDAO(DataSource dataSource) {
			super();
			this.dataSource = dataSource;
		}
		
		@Transactional
	    public void persist(Student student) {
			Session st = sessionFactory.getCurrentSession() ; 
	        st.persist(student);
	        st.flush();
	    }
		
		@Transactional
	    public void delete(Student student) {
			Session st = sessionFactory.getCurrentSession() ; 
	        st.delete(student);
	        st.flush();
	        FacesMessage msg = new FacesMessage("Car Selected", student.getEmail());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
		
		
		
		public List<Student> listPersons() {
			try {
				Connection conn = dataSource.getConnection();
				String sql = "select * from student";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet l = ps.executeQuery() ; 
				while(l.next()){
					System.out.println(l.getString(2));
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null ; 
		}
	    
		@Transactional
	    public List<Student> list() {
	        @SuppressWarnings("unchecked")
	        List<Student> listUser = (List<Student>) sessionFactory.getCurrentSession().createQuery("from Student").list() ; 
	        System.out.println(listUser);
	        return listUser;
	    }
	   
}
