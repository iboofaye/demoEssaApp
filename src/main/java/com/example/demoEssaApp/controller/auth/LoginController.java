/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author LENOVO
 */

@Controller
public class LoginController {
    /** Display login screen
     * @return  */
    @GetMapping ("/login" )
    public String getLogin() {
        return "login/login" ;
    }
}
