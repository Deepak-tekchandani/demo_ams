package com.demo.am.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.am.dto.TeacherDTO;
import com.demo.am.entities.TeacherEntity;
import com.demo.am.services.TeacherService;
import com.demo.am.transformer.TeacherTransformer;

@RestController
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	
	@PostMapping("/addteacher")
		public ResponseEntity<TeacherDTO> addTeacher(TeacherDTO teacherDTO) {
		TeacherDTO teacherDTO2=null;		
		try {
			TeacherEntity teacherEntity= TeacherTransformer.getTeacherEntity(teacherDTO);
			teacherEntity.setStatus(true);
			TeacherEntity teacher =  this.teacherService.addTeacher(teacherEntity);			
			teacherDTO2=TeacherTransformer.getTeacherDTO(teacher);
			return ResponseEntity.of(Optional.of(teacherDTO2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
	}
	
	@GetMapping("/allteacher")
	public ResponseEntity<List<TeacherDTO>> getAllTeacher() {
		List<TeacherDTO> teacherDTOs=null;
		List<TeacherEntity> teacherEntities= teacherService.getAllTeacher();
		if(teacherEntities.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		teacherDTOs= TeacherTransformer.getTeacherDTOs(teacherEntities);
		return ResponseEntity.status(HttpStatus.CREATED).body(teacherDTOs);
		
	}
	
	@GetMapping("/allteacher/{id}")	
	public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable("id") Long teacherId) {
		TeacherEntity teacher = teacherService.getTeacherById(teacherId);
		
		if(teacher==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		TeacherDTO teacherDTO= TeacherTransformer.getTeacherDTO(teacher);
		return ResponseEntity.of(Optional.of(teacherDTO));	
		
	}
	
	@DeleteMapping("/deleteteacher/{id}")
	public ResponseEntity<TeacherDTO> deleteById(@PathVariable("id") Long teacherId) {
		TeacherDTO teacherDTO2=null;
		try {
			TeacherEntity teacher=teacherService.deleteTeacher(teacherId);
			teacherDTO2 =TeacherTransformer.getTeacherDTO(teacher);
			return ResponseEntity.of(Optional.of(teacherDTO2));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	
	}
	
	@PutMapping("/updateteacher")
	public ResponseEntity<TeacherDTO> updateTeacher(TeacherDTO teacherDTO) {	
		try {
			TeacherEntity teacherEntity= TeacherTransformer.getTeacherEntity(teacherDTO);
			teacherEntity.setStatus(true);
			TeacherEntity teacher =  this.teacherService.updateTeacher(teacherEntity);			
			TeacherDTO teacherDTO2=TeacherTransformer.getTeacherDTO(teacher);		
			return ResponseEntity.ok().body(teacherDTO2);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
		


}
