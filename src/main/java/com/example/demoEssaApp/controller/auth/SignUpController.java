/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.controller.auth;

import com.example.demoEssaApp.controller.form.GroupOrder;
import com.example.demoEssaApp.controller.form.SignupForm;
import com.example.demoEssaApp.domain.user.model.MUser;
import com.example.demoEssaApp.domain.user.service.UserService;
import com.example.demoEssaApp.model.AppUser;
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
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    @Autowired
    private UserService userService ;
    @Autowired
    private ModelMapper modelMapper ;

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
        // Convert form to MUser class
        //MUser user = modelMapper.map(form , MUser.class );
        // user signup
        userService.signup(form);
        return "redirect:/login";
    }
    
    /** Database-related exception handling
     * @param e
     * @param model
     * @return  */
    @ExceptionHandler(DataAccessException.class )
    public String dataAccessExceptionHandler(DataAccessException e ,Model model ) {
        // Set an empty string
        model.addAttribute("error" , "" );
        // Register message in Model
        model .addAttribute("message" , "An exception occurred in SignupController" );
        // Register HTTP error code(500) in Model
        model .addAttribute("status" , HttpStatus.INTERNAL_SERVER_ERROR );
        return "error" ;
    }
    /** Other exception handling
     * @param e
     * @param model
     * @return  */
    @ExceptionHandler(Exception.class )
    public String exceptionHandler(Exception e , Model model ) {
        // Set an empty string
        model.addAttribute("error" , "" );
        // Register message in Model
        model.addAttribute("message" , "An exception occurred in SignupController" );
        // Register HTTP error code(500) in Model
        model.addAttribute("status" , HttpStatus.INTERNAL_SERVER_ERROR );
        return "error" ;
    }
}