package com.demo.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.am.entities.TeacherEntity;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long>{

}
