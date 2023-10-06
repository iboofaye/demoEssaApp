/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.controller.auth;

import com.example.demoEssaApp.controller.form.GroupOrder;
import com.example.demoEssaApp.controller.form.SignupForm;
import com.example.demoEssaApp.service.UserApplicationService;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 *
 * @author LENOVO
 */
@Controller
@RequestMapping ("/user" )
@Slf4j
public class SignUpController {
    @Autowired
    private UserApplicationService userApplicationService ;
    /** Display the user signup screen
     * @param model
     * @return  */
    @GetMapping ("/signupsample" )
    public String getSignup(Model model ) {
        // Get gender
        Map<String, Integer> genderMap = userApplicationService.getGenderMap();
        model.addAttribute("genderMap" , genderMap );
        // Transition to user signup screen
        return "user/signup" ;
    }
    
    /** Display the user signup screen
     * @param model
     * @param locale
     * @param form
     * @return  */
    @GetMapping ("/signup" )
    public String getSignupMessage(Model model, Locale locale, @ModelAttribute SignupForm form) {
        // Get gender
        Map<String, Integer> genderMap = userApplicationService.getGenderMapMessage(locale);
        model.addAttribute("genderMap" , genderMap );
        // Transition to user signup screen
        return "user/signupmessage";
    }
    /** User signup process
     * @param model
     * @param locale
     * @param form
     * @param bindingResult
     * @return  */
    @PostMapping ("/signup" )
    public String postSignup(Model model , Locale locale , @ModelAttribute @Validated(GroupOrder.class) SignupForm form , BindingResult bindingResult ) {
        // Input check result
        if (bindingResult.hasErrors()) {
            // NG: Return to the user signup screen
            return getSignupMessage(model , locale , form );
        }
        // Redirect to login screen
        log.info(form.toString());
        return "redirect:/login";
    }
}