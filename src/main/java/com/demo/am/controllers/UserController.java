package com.demo.am.controllers;

import com.demo.am.dto.RoleDTO;
import com.demo.am.dto.UserDTO;
import com.demo.am.entities.RoleModel;
import com.demo.am.entities.UserModel;
import com.demo.am.services.UserService;
import com.demo.am.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<UserDTO> addUserModel(UserDTO userDTO){
        try {
            UserModel userModel = UserTransformer.getUserEntity(userDTO);
            userModel.setStatus(true);
            UserModel user = this.userService.addUserModel(userModel);
            UserDTO userDTO2 = UserTransformer.getUserDTO(user);
            return ResponseEntity.of(Optional.of(userDTO2));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/getuser")
    public ResponseEntity<List<UserDTO>> getAllRole() {
        List<UserDTO> userDTOs=null;
        List<UserModel> userEntities= userService.getAllUsers();
        if(userEntities.size()<=0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userDTOs= UserTransformer.getUserDTOs(userEntities);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTOs);

    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") long userId) {
        UserModel user= userService.getUserModelById(userId);

        if(user==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        UserDTO userDTO= UserTransformer.getUserDTO(user);
        return ResponseEntity.of(Optional.of(userDTO));

    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<UserDTO> deleteById(@PathVariable("id") UserModel userModel) {
        UserDTO userDTO2=null;
        try {
            UserModel user=userService.deleteUserModel(userModel);
            userDTO2 =UserTransformer.getUserDTO(user);
            return ResponseEntity.of(Optional.of(userDTO2));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }



    }

    @PutMapping("/updateuser")
    public ResponseEntity<UserDTO> updateuser(UserDTO userDTO) {
        try {
            UserModel userEntity=UserTransformer.getUserEntity(userDTO);
            userEntity.setStatus(true);
            UserModel user =  this.userService.updateUserModel(userEntity);
            UserDTO userDTO2=UserTransformer.getUserDTO(user);
            return ResponseEntity.ok().body(userDTO2);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getuserByName")
    public List<UserDTO> findUserByuserName(String userName) {
        if (userName!=null)
            return UserTransformer.getUserDTOs(userService.findUserByuserName(userName));
        return UserTransformer.getUserDTOs(userService.getAllUsers());
    }

}
