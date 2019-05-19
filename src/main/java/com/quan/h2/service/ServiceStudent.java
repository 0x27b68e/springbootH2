package com.quan.h2.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.quan.h2.model.Student;

@Service
public interface ServiceStudent  extends CrudRepository<Student, Integer>{

	List<Student> findByName(String string); //start with findBy, and end with Name, one of  the  property of Student, magic behind the sense

	List<Student> findByScore(int i);

	List<Student> findByIdGreaterThan(int id);

	@Query("from Student where score = ?1 order by name")
	List<Student> findByScoreSorted(int score);



}
