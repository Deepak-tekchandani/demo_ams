package com.demo.am.servicesImple;

import com.demo.am.entities.RoleModel;
import com.demo.am.repositories.RoleRepository;
import com.demo.am.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleModel addRoleModel(RoleModel roleModel) {
		RoleModel role = roleRepository.save(roleModel);
		return role;
	}

	@Override
	public RoleModel updateRoleModel(RoleModel roleModel) {
		RoleModel entity = roleRepository.getById(roleModel.getRoleId());
		if (entity != null) {
			return roleRepository.save(roleModel);
		}

		return null;
	}

	@Override
	public RoleModel deleteRoleModel(RoleModel roleModel) {
		RoleModel roleEntity = roleRepository.getById(roleModel.getRoleId());
		roleEntity.setStatus(false);
		roleRepository.delete(roleEntity);
		return roleEntity;
	}

	@Override
	public RoleModel getRoleModelById(Long roleId) {
		Optional<RoleModel> optional = roleRepository.findById(roleId);
		RoleModel roleEntity = null;

		if (optional.isPresent()) {
			roleEntity = optional.get();
		} else {
			throw new RuntimeException("Student not found for id :: " + roleId);
		}
		return roleEntity;
	}

	@Override
	public List<RoleModel> getAllRoleModels() {
		List<RoleModel> list = (List<RoleModel>) this.roleRepository.findAll();
		return list;
	}

	@Override
	public List<RoleModel> getAllRoleModels(String roleName, Integer first, Integer pageSize, String sortField,
											String orderBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getTotalRolesByName(String roleName) {
//		Optional<RoleModel> optional = roleRepository.findAll(RoleModel.getRoleName);
//		RoleModel roleEntity=null;
//
//		if(optional.isPresent()) {
//			roleEntity=optional.get();
//		}
//		else {
//			throw new RuntimeException("Student not found for id :: "+roleId);
//		}
		return null;
	}

	@Override
	public List<RoleModel> findByRoleName(String roleName) {

		return roleRepository.findByRoleName(roleName);
	}


}