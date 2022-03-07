package com.demo.am.services;

import java.util.List;

import com.demo.am.entities.FacilityEntity;

// built in @Component
public interface FacilityService {
	
	public FacilityEntity addFacility(FacilityEntity facilityEntity);
	public List<FacilityEntity> getAllFacility();
	public FacilityEntity getFacilityById(Long facilityId);
	public FacilityEntity deleteFacility(Long facilityId);
	public FacilityEntity updateFacility(FacilityEntity facilityEntity);
	
	

}
