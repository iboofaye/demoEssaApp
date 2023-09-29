/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.controller.auth;

import com.example.demoEssaApp.service.UserApplicationService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author LENOVO
 */
@Controller
@RequestMapping ("/user" )
public class SignUpController {
    @Autowired
    private UserApplicationService userApplicationService ;
    /** Display the user signup screen
     * @param model
     * @return  */
    @GetMapping ("/signup" )
    public String getSignup(Model model ) {
        // Get gender
        Map<String, Integer> genderMap = userApplicationService.getGenderMap();
        model.addAttribute("genderMap" , genderMap );
        // Transition to user signup screen
        return "user/signup" ;
    }
    
    /** Display the user signup screen
     * @param model
     * @return  */
    @GetMapping ("/signupmessage" )
    public String getSignupMessage(Model model ) {
        // Get gender
        Map<String, Integer> genderMap = userApplicationService.getGenderMapMessage();
        model.addAttribute("genderMap" , genderMap );
        // Transition to user signup screen
        return "user/signupmessage" ;
    }
    /** User signup process
     * @return  */
    @PostMapping ("/signup" )
    public String postSignup() {
        // Redirect to login screen
        return "redirect:/login" ;
    }
}