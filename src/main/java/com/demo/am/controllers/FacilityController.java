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

import com.demo.am.dto.FacilityDTO;
import com.demo.am.entities.FacilityEntity;
import com.demo.am.services.FacilityService;
import com.demo.am.transformer.FacilityTransformer;

@RestController
public class FacilityController {
	
	
	@Autowired
	private FacilityService facilityService;
	
	
	@PostMapping("/addfacility")
//	public FacilityEntity addFacility(@RequestBody FacilityEntity facilityEntity) {
//		FacilityEntity facility =  this.facilityService.addFacility(facilityEntity);
//		return facility;
	
		public ResponseEntity<FacilityDTO> addFacility(FacilityDTO facilityDTO) {
		FacilityDTO facilityDTO2=null;		
		try {
			FacilityEntity facilityEntity= FacilityTransformer.getFacilityEntity(facilityDTO);	
			facilityEntity.setStatus(true);
			FacilityEntity facility =  this.facilityService.addFacility(facilityEntity);			
			facilityDTO2=FacilityTransformer.getFacilityDTO(facility);
			return ResponseEntity.of(Optional.of(facilityDTO2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
	}
	
	@GetMapping("/allfacility")
//	public List<FacilityEntity> getAllFacility() {
//		List<FacilityEntity> facilityEntity =  facilityService.getAllFacility();
//		return facilityEntity;
	
	public ResponseEntity<List<FacilityDTO>> getAllFacility() {
		List<FacilityDTO> facilityDTOs=null;
		List<FacilityEntity> facilityEntities= facilityService.getAllFacility();
		if(facilityEntities.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		facilityDTOs= FacilityTransformer.getFacilityDTOs(facilityEntities);
		return ResponseEntity.status(HttpStatus.CREATED).body(facilityDTOs);
		
	}
	
	@GetMapping("/allfacility/{id}")	
//	public FacilityEntity  getFacilityById(@PathVariable("id") Long facilityId) {
//		FacilityEntity facilityEntity = facilityService.getFacilityById(facilityId);
//		return facilityEntity;
	public ResponseEntity<FacilityDTO> getFacilityById(@PathVariable("id") Long facilityId) {
		FacilityEntity facility = facilityService.getFacilityById(facilityId);
		
		if(facility==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		FacilityDTO facilityDTO= FacilityTransformer.getFacilityDTO(facility);
		return ResponseEntity.of(Optional.of(facilityDTO));	
		
	}
	
	@DeleteMapping("/deletefacility/{id}")
//	public FacilityEntity deleteById(@PathVariable("id") Long facilityId) {
//		facilityService.deleteFacility(facilityId);
//		return null;
	public ResponseEntity<FacilityDTO> deleteById(@PathVariable("id") Long facilityId) {
		FacilityDTO facilityDTO2=null;
		try {
			FacilityEntity facility=facilityService.deleteFacility(facilityId);
			facilityDTO2 =FacilityTransformer.getFacilityDTO(facility);
			return ResponseEntity.of(Optional.of(facilityDTO2));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	
	}
	
	@PutMapping("/updatefacility")
//	public FacilityEntity updatefacility(@RequestBody FacilityEntity facilityEntity,@PathVariable("id") Long facilityId ) {
//		 this.facilityService.updateFacility(facilityEntity,facilityId);
//		return facilityEntity;
	
	public ResponseEntity<FacilityDTO> updatefacility(FacilityDTO facilityDTO) {	
		try {
			FacilityEntity facilityEntity= FacilityTransformer.getFacilityEntity(facilityDTO);
			facilityEntity.setStatus(true);
			FacilityEntity facility =  this.facilityService.updateFacility(facilityEntity);			
			FacilityDTO facilityDTO2=FacilityTransformer.getFacilityDTO(facility);		
			return ResponseEntity.ok().body(facilityDTO2);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
		


}
