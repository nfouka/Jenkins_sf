package com.concretepage;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.showcase.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concretepage.dao.Client;
import com.concretepage.model.Student;


@ManagedBean(name = "studentBean", eager = true)
@RequestScoped
@Component
public class StudentBean {
	private String name;
	private Integer id;
	
	@Autowired
	public StudentService userService;
	@Autowired
	public Client clientConf ; 
	@Autowired
	public StudentImpDAO studentImpDAO ; 
	
	private Student selectedCar;
	private List<Student> student ;
	
	
    public Student getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Student selectedCar) {
		this.selectedCar = selectedCar;
	}

	public List<Student> getSelectedCars() {
		return selectedCars;
	}

	public void setSelectedCars(List<Student> selectedCars) {
		this.selectedCars = selectedCars;
	}

	private List<Student> selectedCars;
	
	
	public List<Student> getList(){
		return studentImpDAO.list() ; 
	}
	
	
	public void deleteStudent(Student student){
		 studentImpDAO.delete(student);
		 System.err.println(student+" has been removed.");
		 ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		 try {
			 //this.student =  studentImpDAO.list() ; 
			 init();
			context.redirect(context.getRequestContextPath() + "/output.jsf" );
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public String fetchStudent(){
		name = userService.getStudent(id); 
		clientConf.sayHello() ; 
		studentImpDAO.listPersons(); 
		studentImpDAO.list() ; 
		return "output";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((Student) event.getObject()).getEmail());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((Student) event.getObject()).getFirstName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	@PostConstruct
	public void init() {
	
		for(int i=0 ; i<100 ; i++) {
		Student st = new Student("Anrand "+ Math.random(), "Michel", "nadir.fouka@"+Math.random()+".com", "+213 85 96 7850 80") ; 
			//studentImpDAO.persist(st);
		}
		student = studentImpDAO.list() ; 
		
	}
	
	
	 public void showMessage() {
	        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity."));
	    }
	
	 public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public void destroyWorld() {
	        addMessage("System Error", "Please try again later.");
	    }
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
}