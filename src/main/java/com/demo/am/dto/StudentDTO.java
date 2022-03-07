package com.demo.am.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends DTO{
	
	private String studentId;
	private String studentName;
	private String studentAddress;
	private String studentNumber;
	
	private TeacherDTO teacherDTO;

}
