package com.demo.am.servicesImple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.am.entities.Entities;
import com.demo.am.entities.StudentEntity;
import com.demo.am.repositories.StudentRepository;
import com.demo.am.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentEntity addStudent(StudentEntity studentEntity) {
		StudentEntity student= studentRepository.save(studentEntity);
		return student;
	}

	@Override
	public List<StudentEntity> getAllStudent() {
		List<StudentEntity> studentList = (List<StudentEntity>) this.studentRepository.findAll();
		return studentList;
	}

	@Override
	public StudentEntity getStudentById(Long studentId) {
		Optional<StudentEntity> optional = studentRepository.findById(studentId);
		StudentEntity studentEntity=null;
		
		if(optional.isPresent()) {
			studentEntity=optional.get();
		}
		else {
			throw new RuntimeException("Student not found for id :: "+studentId);
		}
		return studentEntity;
	}

	@Override
	public StudentEntity deleteStudent(Long studentId) {
		StudentEntity studentEntity= studentRepository.getById(studentId);
		studentEntity.setStatus(false);
		studentRepository.delete(studentEntity);
		return studentEntity;
	}

	@Override
	public StudentEntity updateStudent(StudentEntity studentEntity) {
		StudentEntity student= studentRepository.getById(studentEntity.getStudentId());
		if(student!=null) {
			return studentRepository.save(studentEntity);
		}
		return null;
	}

}
