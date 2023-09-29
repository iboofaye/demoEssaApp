/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.controller.form;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 *
 * @author LENOVO
 */

@Data
public class SignupForm {
private String userId ;
private String password ;
private String userName ;
@DateTimeFormat (pattern = "dd/MM/yyyy" )
private Date birthday ;
private Integer age ;
private Integer gender ;
}