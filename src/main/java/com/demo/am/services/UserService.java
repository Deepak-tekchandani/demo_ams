package com.demo.am.services;

import com.demo.am.entities.RoleModel;
import com.demo.am.entities.UserModel;

import java.util.List;


public interface UserService {
	
	public UserModel addUserModel(UserModel userModel);
	public UserModel updateUserModel(UserModel userModel);
	public UserModel deleteUserModel(UserModel userModel);
	public UserModel getUserModelById(Long userId);
	//public List<RoleDataPermissionModel> getAllUserModels(Integer roleId);
	public List<UserModel> getUserModelByRoleId(RoleModel roleModel);
	public UserModel getActiveUsers(String name, String password);
	public UserModel getActiveUser(String name);
	public UserModel getAllPropertiesOfUserByUserId(Integer userId);
	public List<UserModel> getAllUserByProperty(String name, Integer role, Integer first, Integer pageSize, String sortField, String orderBy);
	public List<UserModel> getAllUsers();
	//public List<RoleDataPermissionModel> getAllUserByProperty(String name, Integer userRole, Integer roleId);
	public UserModel getUserByEmployee(Integer employeeId);
	public UserModel getUserByUserName(String userName);
	public UserModel getUserDetailsByUserName(String userName);
	public List<UserModel> getAllUserByLocation(Integer location);
	public UserModel loginUser(String userName, String password);
	public Long getTotalUsers(String name, Integer roleId);
	public UserModel getUserModelByUserName(String userName);
	//public LoginInfoModel addLoginInfo(LoginInfoModel loginInfoModel);
	//public LoginInfoModel getLastLogin(Integer userId);
	public Long getTotalUsers();
	public Long getTotalUsers(String institutionId);

	List<UserModel> findUserByuserName(String userName);
	
	
}
