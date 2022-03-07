package com.demo.am.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Where(clause = "status=true")
@Table(name="facility", catalog="amsapphire")
public class FacilityEntity extends Entities{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="facility_id")
	private Long facilityId;
	
	@Column(name="facility_name")
	private String facilityName;
	
	
	//private boolean status = true;

}
