/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.controller;

import com.example.demoEssaApp.controller.form.UserListForm;
import com.example.demoEssaApp.domain.user.model.MUser;
import com.example.demoEssaApp.domain.user.service.UserService;
import com.example.demoEssaApp.model.AppUser;
import com.example.demoEssaApp.repository.MUserRepository;
import com.example.demoEssaApp.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author LENOVO
 */
@Controller
@RequestMapping ("/user" )
public class UserListController {
    
    @Autowired
    private UserService userService;
    /** Display user list screen
     * @param model
         * @return  */
    /*@GetMapping ("/list" )
    public String getUserList(Model model){
        // Get user list
        List<MUser> userList = userService.getUsers();
        // Registered in Model
        model.addAttribute("userList" , userList);
        // Display user list screen
        return "user/list";
    }*/
    
    /** Display user list screen
     * @param form
     * @param model
     * @return  */
    @GetMapping ("/list" )
    public String getUserList(@ModelAttribute UserListForm form , Model model ) {
        // Convert form to MUser class
        //MUser user = modelMapper.map(form , MUser.class );
        MUser user = new MUser();
        user.setUserId(form.getUserId());
        user.setUserName(form.getUserName());
        // Get user list
        List<MUser> userList = userService.getUsers();
        // Registered in Model
        model.addAttribute("userList" , userList );
        // Display user list screen
    return "user/list" ;
}
    /** User search process
     * @param form
     * @param model
     * @return  */
    @PostMapping ("/list" )
    public String postUserList(@ModelAttribute UserListForm form , Model model ) {
        // Convert form to MUser class
        //MUser user = modelMapper .map(form , MUser.class );
        MUser user = new MUser();
        user.setUserId(form.getUserId());
        user.setUserName(form.getUserName());
        // Get user list
        List<MUser> userList = null;
        if(!form.getUserId().isEmpty() && !form.getUserName().isEmpty()){
            userList = null;
        }else if(!form.getUserId().isEmpty()){
            userList = userService.getUsersByUserId(form.getUserId());
        }else if(!form.getUserName().isEmpty()){
            userList = userService.getUsersByUserName(form.getUserName());
        }
        // Registered in Model
        model.addAttribute("userList" , userList );
        // Display user list screen
        return "user/list";
    }
}