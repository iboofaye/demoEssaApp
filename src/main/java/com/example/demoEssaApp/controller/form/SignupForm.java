/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.controller.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author LENOVO
 */

@Data
public class SignupForm {
    @NotBlank(message = "{require_check}" )
    @Email
    private String userId ;
    @NotBlank
    @Length (min = 4, max = 100)
    @Pattern (regexp = "^[a-zA-Z0-9]+$" )
    private String password ;
    @NotBlank
    private String userName ;
    @DateTimeFormat (pattern = "dd/MM/yyyy" )
    @NotNull
    private Date birthday ;
    @Min (20)
    @Max (100)
    private Integer age ;
    @NotNull
    private Integer gender ;
}