package com.demo.am.transformer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.demo.am.dto.TeacherDTO;
import com.demo.am.entities.TeacherEntity;
import com.demo.am.util.MyDateFormatter;


public class TeacherTransformer {
	
	public static TeacherDTO getTeacherDTO(TeacherEntity model) {
		TeacherDTO dto = new TeacherDTO();
		if(model.getTeacherId()!=null) {
			dto.setTeacherId(String.valueOf(model.getTeacherId()));
		}
		if(model.getTeacherName()!=null) {
			dto.setTeacherName(model.getTeacherName());
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
	
	public static TeacherEntity getTeacherEntity(TeacherDTO dto) {
		TeacherEntity model = new TeacherEntity();
		if(dto.getTeacherId()!=null) {
			model.setTeacherId(Long.valueOf(dto.getTeacherId()));
		}
		if(dto.getTeacherName()!=null) {
			model.setTeacherName(dto.getTeacherName());
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
	
	public static List<TeacherDTO> getTeacherDTOs(List<TeacherEntity> entities) {
		List<TeacherDTO> teacherDTOs=new ArrayList<>();
		for(TeacherEntity e: entities) {
			teacherDTOs.add(TeacherTransformer.getTeacherDTO(e));
		}
		
		return teacherDTOs;
	}

}
