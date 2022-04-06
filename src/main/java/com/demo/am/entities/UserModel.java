package com.demo.am.entities;


import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;


@Getter
@Setter
@Entity
@Where(clause = "status=true")
@Table(name="user")
public class UserModel extends Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="password_modified_date")
	private Timestamp passwordModifiedDate;

	@Column(name="blocked_till")
	private Timestamp blockedTill;

	@Column(name="no_of_tries")
	private Long noOfTries;

	@Column(name="activated")
	private Boolean activated;

	@Column(name="active_all_facilities")
	private Boolean activeAllFacilities;

	@Column(name="authentication_feature_enabled")
	private Boolean authenticationFeature;

	@Column(name="incharge")
	private Boolean incharge;
	
	@Column(name = "mobile_number")
	private String mobileNo;

	// ############################### All associated objects (many-to-one) Go here ######################################
	
	@ManyToOne()
	@JoinColumn(name="role_id")
	private RoleModel role;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="employee_id")
//	private EmployeeModel employee;
		
}

