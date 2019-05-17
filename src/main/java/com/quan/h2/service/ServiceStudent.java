package com.quan.h2.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.quan.h2.model.Student;

@Service
public interface ServiceStudent  extends CrudRepository<Student, Integer>{

}
