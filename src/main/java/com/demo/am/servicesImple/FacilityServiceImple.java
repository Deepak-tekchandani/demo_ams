package com.demo.am.servicesImple;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.am.entities.FacilityEntity;
import com.demo.am.repositories.FacilityRepository;
import com.demo.am.services.FacilityService;

@Service
public class FacilityServiceImple implements FacilityService {
	
	@Autowired
	private FacilityRepository facilityRepository;

	@Override
	public FacilityEntity addFacility(FacilityEntity facilityEntity) {
		
		FacilityEntity facility =  facilityRepository.save(facilityEntity);
		return facility;
		
//		Optional<FacilityEntity> optional = Optional.of(facilityRepository.getById(facilityEntity.getFacilityId()));
//		System.out.println(" berfore .."+optional);
//		if(!optional.isPresent()) {
//			System.out.println(" After .."+optional);
//			FacilityEntity facility =  facilityRepository.save(facilityEntity);
//			return facility;
//		}
//		else {
//			System.out.println(" ....After .."+optional);
//			throw new RuntimeException("Facility id already exist:: "+facilityEntity);
//		}
		
	}

	@Override
	public List<FacilityEntity> getAllFacility() {
		// TODO Auto-generated method stub
		List<FacilityEntity> list=(List<FacilityEntity>) this.facilityRepository.findAll();
		return list;
	}

	@Override
	public FacilityEntity getFacilityById(Long facilityId) {
		// TODO Auto-generated method stub
		Optional<FacilityEntity> optional = facilityRepository.findById(facilityId);
		FacilityEntity facilityEntity=null;
		
		if(optional.isPresent()) {
			facilityEntity=optional.get();
		}
		else {
			throw new RuntimeException("facility not found for id :: "+facilityId);
		}
		return facilityEntity;
	
	}

	@Override
	public FacilityEntity deleteFacility(Long facilityId) {
		// TODO Auto-generated metho
		
		FacilityEntity entityFacility=facilityRepository.getById(facilityId);
		entityFacility.setStatus(false);
		facilityRepository.delete(entityFacility);
		return entityFacility;
	}

	@Override
	public FacilityEntity updateFacility(FacilityEntity facilityEntity) {
		FacilityEntity entity=facilityRepository.getById(facilityEntity.getFacilityId());
		if(entity!=null) {
			return facilityRepository.save(facilityEntity);
		}
		
			return null;
	}

}
