/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.controller.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author LENOVO
 */
@Controller
@Slf4j
public class LogoutController {
/** Redirect to login screen
     * @return  */
@PostMapping ("/logout" )
public String postLogout() {
log .info("Logout" );
return "redirect:/login" ;
}
}