package com.demo.am.transformer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.demo.am.dto.StudentDTO;
import com.demo.am.dto.TeacherDTO;
import com.demo.am.entities.StudentEntity;
import com.demo.am.entities.TeacherEntity;
import com.demo.am.util.MyDateFormatter;

public class StudentTransformer {
	
	public static StudentDTO getStudentDTO(StudentEntity model) {
		StudentDTO dto = new StudentDTO();
		if(model.getStudentId() !=null) {
			dto.setStudentId(String.valueOf(model.getStudentId()));
		}
		if(model.getStudentName() !=null) {
			dto.setStudentName(model.getStudentName());
		}
		if(model.getStudentAddress() !=null) {
			dto.setStudentAddress(model.getStudentAddress());
		}
		if(model.getStudentNumber() !=null) {
			dto.setStudentNumber(String.valueOf(model.getStudentNumber()));
		}
		
		if(model.getTeacher() !=null) {
			
			TeacherDTO teacherDTO=TeacherTransformer.getTeacherDTO(model.getTeacher());
			dto.setTeacherDTO(teacherDTO);
		}
//		if (model.getCreatedBy() != null) {
//			dto.setCreatedBy(model.getCreatedBy().toString());
//		}
//		if (model.getCreatedDate() != null) {
//			dto.setCreatedDate(MyDateFormatter.timeStampToString((Timestamp) model.getCreatedDate()));
//		}
//		if (model.getModifiedBy() != null) {
//			dto.setModifiedBy(model.getModifiedBy().toString());
//		}
//		if (model.getModifiedDate() != null) {
//			dto.setModifiedDate(MyDateFormatter.timeStampToString((Timestamp) model.getModifiedDate()));
//		}
		if (model.getStatus() != null) {
			dto.setStatus(model.getStatus().toString());
		}
		return dto;
	}
	
	public static StudentEntity getStudentEntity(StudentDTO dto) {
		StudentEntity model = new StudentEntity();
		if(dto.getStudentId() !=null) {
			model.setStudentId(Long.valueOf(dto.getStudentId()));
		}
		
		if(dto.getStudentName()!=null) {
			model.setStudentName(dto.getStudentName());
		}
		if(dto.getStudentAddress() !=null) {
			model.setStudentAddress(dto.getStudentAddress());
		}
		if(dto.getStudentNumber() !=null) {
			model.setStudentNumber(Long.valueOf(dto.getStudentNumber()));
		}
		if(dto.getTeacherDTO() !=null) {			
			TeacherEntity entity =TeacherTransformer.getTeacherEntity(dto.getTeacherDTO() );
			model.setTeacher(entity);
		}
//		if (dto.getCreatedBy() != null) {
//			model.setCreatedBy(Long.valueOf(dto.getCreatedBy()));
//		}
//		if (dto.getCreatedDate() != null) {
//			model.setCreatedDate(MyDateFormatter.stringToTimeStamp(dto.getCreatedDate()));
//		}
//		if (dto.getModifiedBy() != null) {
//			model.setModifiedBy(Long.valueOf(dto.getModifiedBy()));
//		}
//		if (dto.getModifiedDate() != null) {
//			model.setModifiedDate(MyDateFormatter.stringToTimeStamp(dto.getModifiedDate()));
//		}
		if (dto.getStatus() != null) {
			model.setStatus(Boolean.valueOf(dto.getStatus()));
		}
		return model;
	}
	
	public static List<StudentDTO> getStudentDTOs(List<StudentEntity> entities) {
		List<StudentDTO> studentDTOs=new ArrayList<>();
		for(StudentEntity e: entities) {
			studentDTOs.add(StudentTransformer.getStudentDTO(e));
		}
		
		return studentDTOs;
	}

}
