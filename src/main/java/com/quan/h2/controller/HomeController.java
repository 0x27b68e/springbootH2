package com.quan.h2.controller;

import java.util.ArrayList;
import java.util.List;

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
	
	@RequestMapping(value = "getStudents")
	public ModelAndView getStudents() {
		List<Student> listStudents = new ArrayList<Student>();
		Iterable<Student> findAll = serviceStudent.findAll();
		findAll.forEach((student) -> listStudents.add(student));
		ModelAndView modelAndView = new ModelAndView("showStudents");
		modelAndView.addObject("listStudents", listStudents);
		
		return modelAndView;
	}
	
	
	
	@RequestMapping("delete")
	public String delete() {
		return "delete";
	}
	
	@RequestMapping(value = "deleteStudent")
	public String deleteStudent(@RequestParam("id") int id) {
		if(serviceStudent.existsById(id)) {
			Student student = serviceStudent.findById(id).get();
			serviceStudent.delete(student);
		}
		return "home";
	}
	
	
	@RequestMapping(value = "update")
	public String update() {
		return "update";
	}
	
	@RequestMapping(value = "updateStudent")
	public ModelAndView updateStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView("studentInfo");
		modelAndView.addObject("student", student);
		serviceStudent.save(student);
		
		return modelAndView;
	}
}
