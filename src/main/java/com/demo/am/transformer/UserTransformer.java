package com.demo.am.transformer;


import com.demo.am.dto.RoleDTO;
import com.demo.am.dto.UserDTO;
import com.demo.am.entities.RoleModel;
import com.demo.am.entities.UserModel;
import com.demo.am.util.MyDateFormatter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class UserTransformer {

	public static UserDTO getUserDTO(UserModel model) {

		UserDTO dto = new UserDTO();

		if (model.getUserId() != null) {
			dto.setUserId(model.getUserId().toString());
		}
		if (model.getUserName() != null) {
			dto.setUserName(model.getUserName());
		}
		if (model.getPassword() != null) {
			dto.setPassword(model.getPassword());
		}
		if (model.getMobileNo() != null) {
			dto.setMobileNo(model.getMobileNo());
		}
		if(model.getRole() !=null) {

			RoleDTO roleDTO=RoleTransformer.getRoleDTO(model.getRole());
			dto.setRoleDTO(roleDTO);
		}
//		if(model.getEmployee() != null) {
//		if (model.getEmployee().getEmployeeId() != null) {
//			dto.setEmployee(model.getEmployee().getEmployeeId().toString());
//		}
//		if (model.getEmployee().getOfficerName() != null) {
//			dto.setEmployeeName(model.getEmployee().getOfficerName());
//		}
//		}
//		else {
//			dto.setEmployeeName("");
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
//			dto.setModifiedDate(MyDateFormatter.timeStampToStringWithTimeMobile((Timestamp) model.getModifiedDate()));
//		}
		if (model.getStatus() != null) {
			dto.setStatus(model.getStatus().toString());
		}
		
		if(model.getAuthenticationFeature()!=null){

			dto.setAuthenticationFeature(model.getAuthenticationFeature().toString());
		}
		if(model.getNoOfTries()!=null){
			dto.setNoOfTries(model.getNoOfTries().toString());
		}
		if(model.getBlockedTill()!=null){
			dto.setBlockedTill(MyDateFormatter.timeStampToStringWithTimeMobile(model.getBlockedTill()));
		}
		return dto;
	}

	public static UserModel getUserEntity(UserDTO dto) {
		UserModel model = new UserModel();
		if(dto.getUserId()!=null) {
			model.setUserId(Long.valueOf(dto.getUserId()));
		}
		if(dto.getUserName()!=null) {
			model.setUserName(dto.getUserName());
		}
		if(dto.getPassword()!=null) {
			model.setPassword(dto.getPassword());
		}
		if(dto.getMobileNo()!=null) {
			model.setMobileNo(dto.getMobileNo());
		}
		if(dto.getRoleDTO() !=null) {
			RoleModel entity =RoleTransformer.getRoleEntity(dto.getRoleDTO() );
			model.setRole(entity);
		}
//		if(dto.getEmployee() != null) {
//		if (dto.getEmployee().getEmployeeId() != null) {
//			model.setEmployee(dto.getEmployee().getEmployeeId().toString());
//		}
//		if (dto.getEmployee().getOfficerName() != null) {
//			model.setEmployeeName(dto.getEmployee().getOfficerName());
//		}
//		}
//		else {
//			model.setEmployeeName("");
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
		if (dto.getStatus() != null) {
			model.setStatus(Boolean.valueOf(dto.getStatus()));
		}
//		if(dto.getAuthenticationFeature()!=null){
//
//			model.setAuthenticationFeature(dto.getAuthenticationFeature().toString());
//		}
//		if(dto.getNoOfTries()!=null){
//			model.setNoOfTries(Long.valueOf(dto.getNoOfTries()));
//		}
//		if(model.getBlockedTill()!=null){
//			dto.setBlockedTill(MyDateFormatter.timeStampToStringWithTimeMobile(model.getBlockedTill()));
//		}
		return model;
	}

	public static List<UserDTO> getUserDTOs(List<UserModel> entities) {
		List<UserDTO> userDTOs=new ArrayList<>();
		for(UserModel e: entities) {
			userDTOs.add(UserTransformer.getUserDTO(e));
		}

		return userDTOs;
	}
}
