/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.domain.user.service.impl;

import com.example.demoEssaApp.controller.form.SignupForm;
import com.example.demoEssaApp.domain.user.model.MUser;
import com.example.demoEssaApp.domain.user.service.UserService;
import com.example.demoEssaApp.mapper.UserMapper;
import com.example.demoEssaApp.model.AppUser;
import com.example.demoEssaApp.repository.MUserRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author LENOVO
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    //@Autowired
    //private UserMapper mapper;
    @Autowired
    private MUserRepository muserRepository;
    
    /** User signup
     */
    
    @Override
    public void signup(SignupForm form) {
        MUser muser = new MUser();
        muser.setUserId(form.getUserId());
        muser.setAge(form.getAge());
        muser.setGender(form.getGender());
        muser.setBirthday(form.getBirthday());
        muser.setPassword(form.getPassword());
        muser.setUserName(form.getUserName());
        //log.info(muser.toString());
        muser.setDepartmentId(1);
        muser.setRole("ROLE_GENERAL");
        //System.out.println(usr.toString());
        muserRepository.save(muser);
        //log.info("Saved !!");
        //mapper.insertOne(user);
    }

    @Override
    public List<MUser> getUsers() {
        return (List<MUser>)muserRepository.findAll();
    }
    
    /** Get user(1record) */
    @Override
    public MUser getUserOne(String userId ) {
        //return muserRepository.findOne(userId);
        return muserRepository.findByUserId(userId);
    }
    
        /** Update user */
    @Override
    public void updateUserOne(String userId ,String password ,String userName ) {
        MUser usr = new MUser();
        usr = muserRepository.findByUserId(userId);
        usr.setUserId(userId);
        usr.setPassword(password);
        usr.setUserName(userName);
        muserRepository.save(usr);
    }
    /** Delete user */
    @Override
    public void deleteUserOne(String userId ) {
        MUser usr = new MUser();
        usr = muserRepository.findByUserId(userId);
        muserRepository.delete(usr);
    }
    
}