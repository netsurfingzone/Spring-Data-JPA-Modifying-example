package com.netsurfingzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netsurfingzone.entity.Student;
import com.netsurfingzone.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insertStudent(@RequestBody Student student) {
		String response = studentService.insertStudent(student);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	@ResponseBody
	public String updateStudent(@RequestBody Student student) {
		String response = studentService.updateStudent(student);
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Student getStudent(@PathVariable int id) {
		Student student = studentService.findById(id);
		return student;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteStudent(@RequestBody Student student) {
		String response = studentService.deleteStudent(student);
		return response;
	}
	
	@RequestMapping(value = "/jpql/{rollnumber}", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getJpqlStudent(@PathVariable String rollnumber) {
		List<Student> students = studentService.findStudentsUsingJpql(rollnumber);
		return students;
	}

	@RequestMapping(value = "/nativequery/{rollnumber}", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getNativeStudent(@PathVariable String rollnumber) {
		List<Student> students = studentService.findStudentsUsingJpql(rollnumber);
		return students;
	}
}