package net.viralpatel.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.viralpatel.spring.model.Student;

@Controller
public class HelloController {
	
	@Autowired
	private Student student ; 

	@GetMapping("/")
	public String hello(Model model) {

		model.addAttribute("name", "John Doe " + student.sayHello() );
		return "welcome";
	}
}
