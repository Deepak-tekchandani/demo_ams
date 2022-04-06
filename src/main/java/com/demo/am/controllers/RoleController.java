package com.demo.am.controllers;

import com.demo.am.dto.RoleDTO;
import com.demo.am.entities.RoleModel;
import com.demo.am.services.RoleService;
import com.demo.am.transformer.RoleTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;


    @PostMapping("/addrole")
    public ResponseEntity<RoleDTO> addFacility(RoleDTO roleDTO) {
        RoleDTO roleDTO2=null;
        try {
            RoleModel roleEntity= RoleTransformer.getRoleEntity(roleDTO);
            roleEntity.setStatus(true);
            RoleModel role =  this.roleService.addRoleModel(roleEntity);
            roleDTO2= RoleTransformer.getRoleDTO(role);
            return ResponseEntity.of(Optional.of(roleDTO2));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/getrole")
    public ResponseEntity<List<RoleDTO>> getAllRole() {
        List<RoleDTO> roleDTOs=null;
        List<RoleModel> roleEntities= roleService.getAllRoleModels();
        if(roleEntities.size()<=0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        roleDTOs= RoleTransformer.getRoleDTOs(roleEntities);
        return ResponseEntity.status(HttpStatus.CREATED).body(roleDTOs);

    }

    @GetMapping("/allrole/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable("id") Long roleId) {
        RoleModel role = roleService.getRoleModelById(roleId);

        if(role==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        RoleDTO roleDTO= RoleTransformer.getRoleDTO(role);
        return ResponseEntity.of(Optional.of(roleDTO));

    }

    @DeleteMapping("/deleterole/{id}")
    public ResponseEntity<RoleDTO> deleteById(@PathVariable("id") RoleModel roleModel) {
        RoleDTO roleDTO2=null;
        try {
            RoleModel role=roleService.deleteRoleModel(roleModel);
            roleDTO2 =RoleTransformer.getRoleDTO(role);
            return ResponseEntity.of(Optional.of(roleDTO2));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }



    }

    @PutMapping("/updaterole")
    public ResponseEntity<RoleDTO> updaterole(RoleDTO roleDTO) {
        try {
            RoleModel roleEntity=RoleTransformer.getRoleEntity(roleDTO);
            roleEntity.setStatus(true);
            RoleModel role =  this.roleService.updateRoleModel(roleEntity);
            RoleDTO roleDTO2=RoleTransformer.getRoleDTO(role);
            return ResponseEntity.ok().body(roleDTO2);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getroleByName")
    public List<RoleDTO> getByName(String roleName) {
        if (roleName!=null)
            return RoleTransformer.getRoleDTOs(roleService.findByRoleName(roleName));
        return RoleTransformer.getRoleDTOs(roleService.getAllRoleModels());
    }

}
