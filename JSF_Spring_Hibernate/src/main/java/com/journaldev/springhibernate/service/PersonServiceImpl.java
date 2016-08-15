package com.journaldev.springhibernate.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.springhibernate.dao.PersonDAO;
import com.journaldev.springhibernate.model.Person;

@Service
@ManagedBean(name="personService")
@SessionScoped
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;
	@Inject
	private Student student ; 
	 
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
 
    @Override
    @Transactional
    public void addPerson(Person p) {
        this.personDAO.addPerson(p);
    }
 
    @Override
    @Transactional
    public List<Person> listPersons() {
    	student.sayHello();
        return this.personDAO.listPersons();
    }

	@Override
	public void deletePerson(int id) {
		// TODO Auto-generated method stub
		 this.personDAO.deletePerson(id);
	}
 
}
