package com.demo.am.transformer;

import com.demo.am.dto.RoleDTO;
import com.demo.am.entities.RoleModel;


import java.util.ArrayList;
import java.util.List;

public class RoleTransformer {

	public static RoleDTO getRoleDTO(RoleModel model) {
		RoleDTO dto = new RoleDTO();
		if(model.getRoleId()!=null) {
			dto.setRoleId(String.valueOf(model.getRoleId()));
		}
		if(model.getRoleName()!=null) {
			dto.setRoleName(model.getRoleName());
		}
		if(model.getDescription()!=null) {
			dto.setRoleDescription(model.getDescription());
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

	public static RoleModel getRoleEntity(RoleDTO dto) {
		RoleModel model = new RoleModel();
		if(dto.getRoleId()!=null) {
			model.setRoleId(Long.valueOf(dto.getRoleId()));
		}
		if(dto.getRoleName()!=null) {
			model.setRoleName(dto.getRoleName());
		}
		if(dto.getRoleDescription()!=null) {
			model.setDescription(dto.getRoleDescription());
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

	public static List<RoleDTO> getRoleDTOs(List<RoleModel> entities) {
		List<RoleDTO> roleDTOs=new ArrayList<>();
		for(RoleModel e: entities) {
			roleDTOs.add(RoleTransformer.getRoleDTO(e));
		}

		return roleDTOs;
	}

}
