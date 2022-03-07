package com.demo.am.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.demo.am.entities.FacilityEntity;
//built in @Repository
public interface FacilityRepository extends CrudRepository<FacilityEntity, Long>, JpaRepository<FacilityEntity, Long> {

}
