package com.netsurfingzone.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.netsurfingzone.entity.Student;

@Component
public interface StudentService {
	public String insertStudent(Student student);

	public String updateStudent(Student student);

	public String deleteStudent(Student student);

	public Student findById(int id);
	
	List<Student> findStudentsUsingNativeQuery(String rollNumber);
	
	List<Student> findStudentsUsingJpql(String rollNumber);

}