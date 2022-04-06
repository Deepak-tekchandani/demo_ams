package com.demo.am.services;

import com.demo.am.entities.RoleModel;

import java.util.List;


public interface RoleService {
	
	public RoleModel addRoleModel(RoleModel roleModel);
	public RoleModel updateRoleModel(RoleModel roleModel);
	public RoleModel deleteRoleModel(RoleModel roleModel);
	public RoleModel getRoleModelById(Long roleId);
	public List<RoleModel> getAllRoleModels();
	public List<RoleModel> getAllRoleModels(String roleName, Integer first, Integer pageSize, String sortField, String orderBy);
	public Long getTotalRolesByName(String roleName);
	List<RoleModel> findByRoleName(String roleName);

}
