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
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author LENOVO
 */
@Entity
@Data
public class Department implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId ;
    private String departmentName ;
    @OneToMany
    private List<MUser> users;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department() {
    }
    
    
    
    
}