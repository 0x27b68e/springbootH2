package com.quan.h2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.quan.h2.model.Student;
import com.quan.h2.service.RestServiceStudent;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	RestServiceStudent restServiceStudent;
	
	/* version 1, return String
	@RequestMapping(value = "getStudent/{id}")
	@ResponseBody
	public String getStudent(@PathVariable("id") int id) {
		restServiceStudent.save(new Student(1, "A", 7));
		restServiceStudent.save(new Student(2, "B", 8));
		Student student = restServiceStudent.findById(id).get();
		
		return student.toString();
	} */
	
	
	// version 2, return Json, from helping of JpaRepository, thanks to Spring boot
	
	@GetMapping(value = "getStudent/{id}")
	public Optional<Student> getStudent2(@PathVariable("id") int id) {
		restServiceStudent.save(new Student(1, "A", 7));
		restServiceStudent.save(new Student(2, "B", 8));
		Optional<Student> student = restServiceStudent.findById(id);
		
		return student;
	}
	
	//this method produce xml instead of default json
	@GetMapping(path="getAllStudent", produces = {"application/xml"})
	public List<Student> getAllStudent() {
		restServiceStudent.save(new Student(1, "A", 7));
		restServiceStudent.save(new Student(2, "B", 8));
		List<Student> findAll = restServiceStudent.findAll();
		
		return findAll;
	}
	
	@PostMapping(path="addStudentRest", consumes = {"application/json"}) // only accept json format from client
	public String addStudentRest(@RequestBody Student student) { // @RequestBody ,suport for client sending raw data
	    restServiceStudent.save(student);
		return "Added";
	}
	
	@PutMapping(path = "updateStudentRest", consumes = {"application/json"})
	public String saveOrUpdateStudentRest(@RequestBody Student student) {
		restServiceStudent.save(student);
		return "updated";
	}
	
	
	@DeleteMapping(value = "deleteStudentRest/{id}")
	public String deleteStudent(@PathVariable int id) {
		restServiceStudent.deleteById(id);
		return "Deleted";
	}
	
	
	
	
	
	
	
	
	
	
	
}
