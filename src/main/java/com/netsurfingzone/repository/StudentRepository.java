package com.netsurfingzone.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.netsurfingzone.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Serializable> {

	@Modifying
	@Query(value = "insert into Student (id,student_name,roll_number, university) "
			+ "VALUES(:id,:studentName,:rollNumber,:university)", nativeQuery = true)
	public void insertStudentUsingQueryAnnotation(@Param("id") int id, @Param("studentName") String studentName,
			@Param("rollNumber") String rollNumber, @Param("university") String university);

	@Modifying
	@Query("update Student s SET s.studentName = :studentName WHERE s.id = :id")
	public void updateStudentUsingQueryAnnotation(@Param("studentName") String studentName, @Param("id") int id);

	@Modifying
	@Query("delete from Student s where s.id = :id")
	public void deleteStudentUsingQueryAnnotation(@Param("id") int id);

	@Query("select s from Student s where s.id = :id")
	public Student findById(@Param("id") int id);
	
/*	@Modifying
	@Query("update Student s SET s.resultStatus = :resultStatus WHERE s.id = :id")
	public void updateStudentRusultStatus(@Param("resultStatus") String studentName, @Param("id") int id);
	*/
	
	@Query(value = "select * from Student s where s.roll_number = ?1", nativeQuery = true)
	List<Student> findStudentsUsingNativeQuery(String rollNumber);
	
	@Query("select s from Student s where s.roll_number = ?1")
	List<Student> findStudentsUsingJpql(String rollNumber);



}