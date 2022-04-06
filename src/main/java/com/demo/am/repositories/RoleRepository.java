package com.demo.am.repositories;

import com.demo.am.entities.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RoleRepository extends JpaRepository <RoleModel, Long> {

    @Query(value = "select rm from RoleModel rm where rm.roleName like ?1%")
    List<RoleModel> findByRoleName(@Param("roleName") String roleName);

}
