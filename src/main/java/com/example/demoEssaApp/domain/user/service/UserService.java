/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.domain.user.service;

import com.example.demoEssaApp.controller.form.SignupForm;
import com.example.demoEssaApp.domain.user.model.MUser;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface UserService {
    
/** User signup
     * @param form */
public void signup(SignupForm form );
/** Get user
     * @return  */
public List<MUser> getUsers();

}
