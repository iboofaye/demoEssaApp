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
    @NotBlank(groups = ValidGroup1.class )
    @Email(groups = ValidGroup2.class )
    private String userId ;
    @NotBlank(groups = ValidGroup1.class )
    @Length(min = 4, max = 100, groups = ValidGroup2.class )
    @Pattern(regexp = "^[a-zA-Z0-9]+$" , groups = ValidGroup2.class )
    private String password ;
    @NotBlank (groups = ValidGroup1.class )
    private String userName ;
    @DateTimeFormat (pattern = "dd/MM/yyyy" )
    @NotNull(groups = ValidGroup1.class )
    private Date birthday ;
    @Min(value = 20, groups = ValidGroup2.class )
    @Max(value = 100, groups = ValidGroup2.class )
    private Integer age ;
    @NotNull (groups = ValidGroup1.class )
    private Integer gender ;
}