/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.controller.form;

import com.example.demoEssaApp.domain.user.model.Department;
import com.example.demoEssaApp.domain.user.model.Salary;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author LENOVO
 */
@Data
public class UserDetailForm {
private String userId ;
private String password ;
private String userName ;
private Date birthday ;
private Integer age ;
private Integer gender ;
private Department department;
private List<Salary> salaryList;
}
