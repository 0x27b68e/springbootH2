package com.quan.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quan.h2.model.Student;
import com.quan.h2.service.ServiceStudent;

@Controller
public class HomeController {

	@Autowired(required = true)
	ServiceStudent serviceStudent;
	
	@RequestMapping(value = "/")
	public String home() {
		serviceStudent.save(new Student(1, "A", 7));
		serviceStudent.save(new Student(2, "B", 8));
		return "home";
	}
	
	@RequestMapping(value = "addStudent")
	public ModelAndView addStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView("studentInfo");
		Student returnStudent = serviceStudent.save(student);
		System.out.println("student is added: " + returnStudent);
		modelAndView.addObject("student", student);
		
		return modelAndView;
	}
	
	
	@RequestMapping("read")
	public String read() {
		return "read";
	}
	
	@RequestMapping("getStudent")
	public ModelAndView getStudent(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView("studentInfo");
		Student student = serviceStudent.findById(id).orElse(new Student());
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	
	
	
	@RequestMapping("delete")
	public String delete() {
		return "delete";
	}
	
	@RequestMapping(value = "deleteStudent")
	public ModelAndView deleteStudent(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView("studentInfo");
		Student student = serviceStudent.findById(id).get();
		System.out.println(student);
		if(student == null) {
			modelAndView.addObject("student", new Student());
			return modelAndView;
		}
		if(student != null) {
		modelAndView.addObject("student", student);
		serviceStudent.delete(student);;
		}
		return modelAndView;
	}
}
