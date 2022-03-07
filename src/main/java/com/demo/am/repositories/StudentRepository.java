package com.demo.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.am.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

}
