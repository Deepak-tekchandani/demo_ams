package com.demo.am.services;

import java.util.List;

import com.demo.am.entities.TeacherEntity;


public interface TeacherService {
	
	public TeacherEntity addTeacher(TeacherEntity teacherEntity);
	public List<TeacherEntity> getAllTeacher();
	public TeacherEntity getTeacherById(Long teacherId);
	public TeacherEntity deleteTeacher(Long teacherId);
	public TeacherEntity updateTeacher(TeacherEntity teacherEntity);
	

}
