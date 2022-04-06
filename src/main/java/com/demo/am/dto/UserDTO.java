package com.demo.am.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends DTO{

	private String userId;
	private String userName;
	private String password;
//	private String employeeName;
	private String mobileNo;
	private String userImage;
//	private String employee;
	private String loginTime;
	private String authenticationFeature;
	private String noOfTries;
	private String blockedTill;
	private RoleDTO roleDTO;

	
}
