/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.controller;

import com.example.demoEssaApp.controller.form.UserDetailForm;
import com.example.demoEssaApp.domain.user.model.MUser;
import com.example.demoEssaApp.domain.user.service.UserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author LENOVO
 */

@Controller
@RequestMapping ("/user")
@Slf4j
public class UserDetailController {
    @Autowired
    private UserService userService ;
    @Autowired
    private ModelMapper modelMapper ;
    /** Display user details screen
     * @param form
     * @param model
     * @param userId
     * @return  */
    @GetMapping("/detail/{userId:.+}" )
    public String getUser(UserDetailForm form , Model model ,@PathVariable("userId" ) String userId ) {
    // Get user
    MUser user = userService.getUserOne(userId);
    user.setPassword(null);
    // Get user
    form.setAge(user.getAge());
    form.setBirthday(user.getBirthday());
    form.setGender(user.getGender());
    form.setUserId(user.getUserId()); 
    form.setUserName(user.getUserName());
    form.setDepartment(user.getDepartment());
    //form = modelMapper.map(user , UserDetailForm.class );
    form.setSalaryList(user.getSalaryList());
    // Registered in Model
    System.out.println("--------------------TesT FORM ----------------------------");
    //System.out.println(form.toString());
    System.out.println("--------------------TesT FORM ----------------------------");
    model.addAttribute("userDetailForm" , form );
    // Display user details screen
    return "user/detail";
    }
    
    /** User update process
     * @param form
     * @param model
     * @return  */
    @PostMapping (value = "/detail" , params = "update" )
    public String updateUser(UserDetailForm form , Model model ) {
        try {
            // Update user
            userService.updateUserOne(form.getUserId(),
            form.getPassword(),
            form.getUserName());
        } catch (Exception e) {
            log.error("Error in user update", e);
        }
        // Redirect to user list screen
        return "redirect:/user/list" ;
    }
    /** User delete process
     * @param form
     * @param model
     * @return  */
    @PostMapping(value = "/detail" , params = "delete" )
    public String deleteUser(UserDetailForm form , Model model ) {
        // Delete user
        userService.deleteUserOne(form.getUserId());
        // Redirect to user list screen
        return "redirect:/user/list" ;
    }
}
