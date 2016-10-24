package org.dciss.dao;

import java.util.List;

import org.dciss.model.Student;

public interface StudentDAO {
		public void getStudenById(int id) ; 
		public List<Student> getAllStuent() ; 
		public void removeStudent(int id) ; 
}
