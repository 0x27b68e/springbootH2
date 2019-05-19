package com.quan.h2.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.quan.h2.model.Student;

@Service
public interface RestServiceStudent  extends JpaRepository<Student, Integer>{

}
