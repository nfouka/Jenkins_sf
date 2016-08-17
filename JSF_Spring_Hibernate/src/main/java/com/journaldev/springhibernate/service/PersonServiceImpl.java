package com.journaldev.springhibernate.service;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.springhibernate.dao.PersonDAO;
import com.journaldev.springhibernate.model.Person;

@Service
@ManagedBean(name="personService")
@SessionScoped
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;
	@Autowired
	private Student student ;
	private ExternalContext externalContext; 
	 
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
 
    @Override
    @Transactional
    public void addPerson(Person p) {
    	ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    	FacesContext.getCurrentInstance().addMessage("j_idt5",new FacesMessage(p.toString()+"Has been added ."));
        this.personDAO.addPerson(p);
        try {
			context.redirect(context.getRequestContextPath() + "/person.xhtml" );
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    
    }
 
    @Override
    @Transactional
    public List<Person> listPersons() {
    	student.sayHello();
        return this.personDAO.listPersons();
    }

	@Override
	public void deletePerson(Person p) {
		// TODO Auto-generated method stub
		FacesContext.getCurrentInstance().addMessage("j_idt5",new FacesMessage( p.toString() +"Has been deleted ."));
		 this.personDAO.deletePerson(p);
		 ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		 try {
			context.redirect(context.getRequestContextPath() + "/person.xhtml" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
}
