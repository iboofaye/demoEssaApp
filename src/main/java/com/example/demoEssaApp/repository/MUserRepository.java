/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.repository;

import com.example.demoEssaApp.domain.user.model.MUser;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO
 */
@Repository
public interface MUserRepository extends JpaRepository<MUser, Long>{

    //public MUser findOne(String userId);
    public MUser findByUserId(String userId); 
    /** Get user
     * @param userid
     * @return  */
    public List<MUser> findByUserIdContains(String userid);
    /** Get user
     * @param username
     * @return  */
    public List<MUser> findByUserNameContains(String username);
   
}
