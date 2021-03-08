package com.netsurfingzone.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netsurfingzone.entity.Student;
import com.netsurfingzone.repository.StudentRepository;
import com.netsurfingzone.service.StudentService;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	@Transactional
	public String insertStudent(Student student) {
		int id = student.getId();
		String studentName = student.getStudentName();
		String rollNumber = student.getRollNumber();
		String university = student.getUniversity();
		studentRepository.insertStudentUsingQueryAnnotation(id, studentName, rollNumber, university);
		return "Record inserted successfully using @Modifiying and @query Named Parameter";
	}

	@Transactional
	public String updateStudent(Student student) {
		studentRepository.updateStudentUsingQueryAnnotation(student.getStudentName(), student.getId());
		return "Record updated successfully using @Modifiying and @query Named Parameter";
	}

	@Override
	@Transactional
	public String deleteStudent(Student student) {
		studentRepository.deleteStudentUsingQueryAnnotation(student.getId());
		return "Record deleted successfully using @Modifiying and @query Named Parameter";
	}
	
	@Transactional
	public Student findById(int id) {
		Student studentresponse = studentRepository.findById(id);		
		return studentresponse;
	}

	@Override
	public List<Student> findStudentsUsingNativeQuery(String rollNumber) {
		List<Student> students = studentRepository.findStudentsUsingJpql(rollNumber);
		return students;
	}

	@Override
	public List<Student> findStudentsUsingJpql(String rollNumber) {
		List<Student> students = studentRepository.findStudentsUsingNativeQuery(rollNumber);
		return students;
	}
	
	

}