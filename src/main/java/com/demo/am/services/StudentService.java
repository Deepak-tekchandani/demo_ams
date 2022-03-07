package com.demo.am.services;

import java.util.List;

import com.demo.am.entities.StudentEntity;


public interface StudentService {
	
	public StudentEntity addStudent(StudentEntity studentEntity);
	public List<StudentEntity> getAllStudent();
	public StudentEntity getStudentById(Long studentId);
	public StudentEntity deleteStudent(Long studentId);
	public StudentEntity updateStudent(StudentEntity studentEntity);

}
