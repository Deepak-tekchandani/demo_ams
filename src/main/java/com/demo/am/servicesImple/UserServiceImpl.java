package com.demo.am.servicesImple;

import com.demo.am.entities.RoleModel;
import com.demo.am.entities.UserModel;
import com.demo.am.repositories.UserRepository;
import com.demo.am.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserModel addUserModel(UserModel userModel) {

		UserModel user =userRepository.save(userModel);
		return user;
	}

	@Override
	public UserModel updateUserModel(UserModel userModel) {
		if (userModel.getUserId() != null) {
			Optional<UserModel> persisted =userRepository.findById(userModel.getUserId());
			if (persisted == null) {
				return null;
			}
			UserModel updated = userRepository.save(userModel);
			return updated;
		}
		return null;
	}

	@Override
	public UserModel deleteUserModel(UserModel userModel) {
		if(userModel.getUserId()!=null){
			userModel.setStatus(false);
			userRepository.save(userModel);
			return userModel;
		}
		return null;
	}

	@Override
	public UserModel getUserModelById(Long userId) {
		Optional<UserModel> optional = userRepository.findById(userId);
		UserModel userEntity = null;

		if (optional.isPresent()) {
			userEntity = optional.get();
		} else {
			throw new RuntimeException("Student not found for id :: " + userId);
		}
		return userEntity;
	}

//	@Override
//	public List<RoleDataPermissionModel> getAllUserModels(Integer roleId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<UserModel> getUserModelByRoleId(RoleModel roleModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getActiveUsers(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getActiveUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getAllPropertiesOfUserByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getAllUserByProperty(String name, Integer role, Integer first, Integer pageSize,
			String sortField, String orderBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getAllUsers() {
		List<UserModel> list = (List<UserModel>) this.userRepository.findAll();
		return list;
	}

//	@Override
//	public List<RoleDataPermissionModel> getAllUserByProperty(String name, Integer userRole, Integer roleId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public UserModel getUserByEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getUserDetailsByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> getAllUserByLocation(Integer location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel loginUser(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getTotalUsers(String name, Integer roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getUserModelByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public LoginInfoModel addLoginInfo(LoginInfoModel loginInfoModel) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public LoginInfoModel getLastLogin(Integer userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Long getTotalUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getTotalUsers(String institutionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> findUserByuserName(String userName) {

		return userRepository.findByUserName(userName);
	}


}
