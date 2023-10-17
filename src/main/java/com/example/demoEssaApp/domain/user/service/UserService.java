/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.domain.user.service;

import com.example.demoEssaApp.controller.form.SignupForm;
import com.example.demoEssaApp.domain.user.model.MUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author LENOVO
 */
public interface UserService {
public void signup(SignupForm form );
/** Get user
     * @return  */
public List<MUser> getUsers();

/** Get user(1record)
     * @param userId
     * @return  */
public MUser getUserOne(String userId);

/** Update user
     * @param userId
     * @param password
     * @param userName */
public void updateUserOne(String userId ,String password ,String userName );
/** Delete user
     * @param userId */
public void deleteUserOne(String userId );

}
