package com.demo.am.servicesImple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.am.entities.TeacherEntity;
import com.demo.am.repositories.TeacherRepository;
import com.demo.am.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public TeacherEntity addTeacher(TeacherEntity teacherEntity) {
		TeacherEntity teacher =teacherRepository.save(teacherEntity);
		return teacher;
	}

	@Override
	public List<TeacherEntity> getAllTeacher() {
	List<TeacherEntity> teacher = (List<TeacherEntity>) this.teacherRepository.findAll();
		return teacher;
	}

	@Override
	public TeacherEntity getTeacherById(Long teacherId) {
		Optional<TeacherEntity> optional = teacherRepository.findById(teacherId);
		TeacherEntity teacherEntity=null;
		
		if(optional.isPresent()) {
			teacherEntity=optional.get();
		}
		else {
			throw new RuntimeException("Student not found for id :: "+teacherId);
		}
		return teacherEntity;
	}

	@Override
	public TeacherEntity deleteTeacher(Long teacherId) {
		TeacherEntity teacherEntity = teacherRepository.getById(teacherId);
		teacherEntity.setStatus(false);
		teacherRepository.delete(teacherEntity);
		return teacherEntity;
	}

	@Override
	public TeacherEntity updateTeacher(TeacherEntity teacherEntity) {
		TeacherEntity teacher = teacherRepository.getById(teacherEntity.getTeacherId());
		if (teacher!=null) {
			return teacherRepository.save(teacherEntity);
		}
		return null;
	}

}
