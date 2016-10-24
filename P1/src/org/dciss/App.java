package org.dciss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dciss.dao.StudentDAOimplement;
import org.dciss.db.DdConnnection;
import org.dciss.db.Student;

import com.abc.Calculator;

/**
 * Servlet implementation class App
 */
@WebServlet("/App")
public class App extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public App() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
	List<org.dciss.model.Student> listStudent = new StudentDAOimplement().getAllStuent() ; 
	request.setAttribute("listStudent", listStudent );	
		
	/* int a = Integer.parseInt( request.getParameter("a") ) ; 
	 int b = Integer.parseInt( request.getParameter("b") ) ; 
	 
	 int result = new Calculator().addition(a, b) ; 
	 request.setAttribute("key", result);
	 request.setAttribute("a", a);
	 request.setAttribute("b", b);
	 
	 LinkedList<Student> list = new DdConnnection("SELECT * FROM `employees` ").executeQuery() ; 
	 request.setAttribute("list", list);
	 
	 
	 System.out.println("logger resuslt is ***************** ************** " + result);
	 System.out.println("logger resuslt is ***************** ************** " + list);
	 System.out.println("a from url is resuslt is ***************** ************** " + a +" , b:" + b );*/
	 request.getRequestDispatcher("/views/page.jsp").forward(request, response);
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
