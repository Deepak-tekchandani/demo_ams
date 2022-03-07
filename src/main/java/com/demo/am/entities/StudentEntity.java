package com.demo.am.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Where(clause = "status=true")
@Table(name="student")
@Entity
public class StudentEntity extends Entities {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private Long studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_address")
	private String studentAddress;
	
	@Column(name="student_number")
	private Long studentNumber;
	
	@ManyToOne()
	@JoinColumn(name="teacher_id")
	private TeacherEntity teacher;
	
	//private boolean status = true;

}
