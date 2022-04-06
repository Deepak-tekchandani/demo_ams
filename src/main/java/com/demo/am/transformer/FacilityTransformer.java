package com.demo.am.transformer;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.demo.am.dto.FacilityDTO;
import com.demo.am.entities.FacilityEntity;
import com.demo.am.util.MyDateFormatter;


public class FacilityTransformer {
	
	public static FacilityDTO getFacilityDTO(FacilityEntity model) {
		FacilityDTO dto = new FacilityDTO();
		if (model.getFacilityId() != null) {
			dto.setFacilityId(model.getFacilityId().toString());
		}
		if (model.getFacilityName() != null) {
			dto.setFacilityName(model.getFacilityName());
		}
//		if (model.getFacilityPassword() != null) {
//			dto.setFacilityPasswoed(model.getFacilityPassword());
//		}
//		if (model.getRole() != null) {
//			dto.setRole(model.getRole());
//		}
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
//		if (model.getStatus() != null) {
//			dto.setStatus(model.getStatus().toString());
//		}
		return dto;
	}
	
	public static FacilityEntity getFacilityEntity(FacilityDTO dto) {
		FacilityEntity model = new FacilityEntity();
		if (dto.getFacilityId() != null) {
			model.setFacilityId(Long.valueOf(dto.getFacilityId()));
		}
		if (dto.getFacilityName() != null) {
			model.setFacilityName(dto.getFacilityName());
		}
//		if (dto.getFacilityPasswoed() != null) {
//			model.setFacilityPassword(dto.getFacilityPasswoed());
//		}
//		if (dto.getRole() != null) {
//			model.setRole(dto.getRole());
//		}
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
//		if (dto.getStatus() != null) {
//			model.setStatus(Boolean.valueOf(dto.getStatus()));
//		}
		return model;
	}
	
	public static List<FacilityDTO> getFacilityDTOs(List<FacilityEntity> entities) {
		List<FacilityDTO> facilityDTOs=new ArrayList<>();
		for(FacilityEntity e: entities) {
			facilityDTOs.add(FacilityTransformer.getFacilityDTO(e));
		}
		
		return facilityDTOs;
	}
	
	public static List<FacilityEntity> getFacilityEntities(List<FacilityDTO> dtos) {
		List<FacilityEntity> facilityEntities=new ArrayList<>();
		for(FacilityDTO dto: dtos) {
			facilityEntities.add(FacilityTransformer.getFacilityEntity(dto));
		}
		
		return facilityEntities;
	}

}
