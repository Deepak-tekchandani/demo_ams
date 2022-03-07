package com.demo.am.controllers;

import java.util.List;
import java.util.Optional;

import com.demo.am.dto.StatusDTO;
import com.demo.am.entities.StudentEntity;
import com.demo.am.entities.TeacherEntity;
import com.demo.am.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.am.dto.StudentDTO;
import com.demo.am.services.StudentService;
import com.demo.am.transformer.StudentTransformer;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	private TeacherService teacherService;
	
	
	@PostMapping("/addStudent")
		public ResponseEntity<StatusDTO> addStudent(StudentDTO studentDTO) {
		StudentDTO studentDTO2=null;		
		try {
			if(studentDTO.getTeacherDTO()!=null) {
				TeacherEntity teacherEntity=teacherService.getTeacherById(Long.parseLong(studentDTO.getTeacherDTO().getTeacherId()));
				if(teacherEntity==null)
					return ResponseEntity.of(Optional.of(new StatusDTO(0, "Teacher Not Found ")));
			}
			StudentEntity studentEntity= StudentTransformer.getStudentEntity(studentDTO);
			studentEntity.setStatus(true);
			StudentEntity student =  this.studentService.addStudent(studentEntity);			
			studentDTO2=StudentTransformer.getStudentDTO(student);
			return ResponseEntity.of(Optional.of(new StatusDTO(1, "Success ",studentDTO2)));
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.of(Optional.of(new StatusDTO(0, "Exception occured "+e.getMessage())));
			
		}
		//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
	}
	
	@GetMapping("/allstudent")
	public ResponseEntity<StatusDTO> getAllStudent() {
		List<StudentDTO> studentDTOs=null;
		List<StudentEntity> studentEntities= studentService.getAllStudent();
		if(studentEntities.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		studentDTOs= StudentTransformer.getStudentDTOs(studentEntities);
		return ResponseEntity.status(HttpStatus.CREATED).body(new StatusDTO(1, "Success ",studentDTOs));
		
	}
	
	@GetMapping("/allstudent/{id}")	
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") Long studentId) {
		StudentEntity student = studentService.getStudentById(studentId);
		
		if(student==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		StudentDTO studentDTO= StudentTransformer.getStudentDTO(student);
		return ResponseEntity.of(Optional.of(studentDTO));	
		
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<StudentDTO> deleteById(@PathVariable("id") Long studentId) {
		StudentDTO studentDTO2=null;
		try {
			StudentEntity student=studentService.deleteStudent(studentId);
			studentDTO2 =StudentTransformer.getStudentDTO(student);
			return ResponseEntity.of(Optional.of(studentDTO2));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	
	}
	
	@PutMapping("/updatestudent")
	public ResponseEntity<StudentDTO> updateStudent(StudentDTO studentDTO) {	
		try {
			StudentEntity studentEntity= StudentTransformer.getStudentEntity(studentDTO);
			studentEntity.setStatus(true);
			StudentEntity student =  this.studentService.updateStudent(studentEntity);			
			StudentDTO studentDTO2=StudentTransformer.getStudentDTO(student);		
			return ResponseEntity.ok().body(studentDTO2);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
		


}
