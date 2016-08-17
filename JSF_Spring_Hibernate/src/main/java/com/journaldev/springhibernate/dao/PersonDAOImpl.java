package com.journaldev.springhibernate.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.springhibernate.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	
	@Inject
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addPerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Person saved successfully, Person Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        for(Person p : personsList){
            logger.info("Person List::"+p);
        }
        return personsList;
    }

	@Override
	public void deletePerson(Person p) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession() ; 
		 session.delete(p);
		 session.flush() ;
		 
	}
 
}
