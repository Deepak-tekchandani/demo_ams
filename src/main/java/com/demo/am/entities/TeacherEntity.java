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

@Getter
@Setter
@Where(clause = "status=true")
@Table(name="teacher")
@Entity
public class TeacherEntity extends Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="teacher_id")
	private Long teacherId;
	
	@Column(name="teacher_name")
	private String teacherName;
	
	//private boolean status = true;

}
