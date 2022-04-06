package com.demo.am.repositories;

import com.demo.am.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository <UserModel, Long> {

    @Query(value = "select um from UserModel um where um.userName like ?1%")
    List<UserModel> findByUserName(@Param("userName") String userName);

}
