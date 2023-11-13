/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.domain.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author LENOVO
 */
@Entity
@Data
public class MUser implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    private String userName;
    private Date birthday;
    private Integer age;
    private Integer gender;
    //private Integer departmentId;
    private String role;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department ;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Salary> salaryList ;

    public MUser(String userId, String password, String userName, Date birthday, Integer age, Integer gender, String role) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.birthday = birthday;
        this.age = age;
        this.gender = gender;
        //this.departmentId = departmentId;
        this.role = role;
    }

    public MUser(String userId, String password, String userName, Date birthday, Integer age, Integer gender, String role, Department department) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.birthday = birthday;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.department = department;
    }
    

    public MUser() {
    }
    
    
}