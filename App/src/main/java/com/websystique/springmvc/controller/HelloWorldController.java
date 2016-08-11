package com.websystique.springmvc.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.EmployeeImpDAO;
import com.websystique.springmvc.model.Entreprise;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	@Autowired
	Employee employee ; 
	
	@Autowired
	Entreprise ent ; 

	
	@Autowired
	DataSource dataSource ; 
	
	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping(value= "/add", method = RequestMethod.GET)
	public String addPerson(@ModelAttribute("employee") Employee p){
		
		Session open = sessionFactory.openSession() ; 
		open.persist(p);
		open.flush();
		return "redirect:/";
		
	}
	
	@RequestMapping("/edit/{id}")
	    public String editPerson(@PathVariable("id") int id, ModelMap model){
		  model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		  	Session open = sessionFactory.openSession() ; 
			Employee p = (Employee) open.load(Employee.class, new Integer(id));
			model.addAttribute("employee", 	p );
			model.addAttribute("ent", 	ent.toString());
	        return "welcome";
	    }
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
		Session open = sessionFactory.openSession() ; 
		Employee p = (Employee) open.load(Employee.class, new Integer(id));
		if(null != p){
			open.delete(p);
			open.flush();
		}
        return "redirect:/";
    }
	
	@RequestMapping(value= "/employee/add", method = RequestMethod.GET)
	public String addEmployee(@ModelAttribute("employee") Employee p){
		Session open = sessionFactory.openSession() ; 
		if(p.getId() == 0){
			//new person, add it
			open.persist(p);
			open.flush();
		}else{
			//existing person, call update
			open.update(p);
			open.flush();
		}
		
		return "add";
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) throws SQLException {
		
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		model.addAttribute("employee", 	new Employee() );
		model.addAttribute("ent", 	ent.toString());
		
		
		String sql = "SELECT * FROM EMPLOYEE where id = ?";
		
		Connection conn = null;
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 1);
		
		ResultSet rs  = ps.executeQuery() ; 
		if(rs.next()){
			Employee emp = new Employee() ; 
			
			emp.setName(rs.getString("name"));
			System.out.println(emp.toString());
			emp.toString() ; 
			
		}
		
		ps.execute() ; 
		ps.close();
		
		
		Session open = sessionFactory.openSession() ; 
		open.persist(new Employee("Nadir " + Math.random() , new Date(), 858, "SSN:"+Math.random()) );

		
		
		List<Employee> l = open.createQuery("from Employee order by id desc").setMaxResults(5).list() ; 
		for(Employee p : l){
			System.out.println(p.toString());
		}
		open.close() ; 
		model.addAttribute("lists",  l );
		return "welcome";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}

}