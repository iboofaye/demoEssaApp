/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.domain.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author LENOVO
 */
@Entity
@Data
public class Salary implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String salaryId ;
    private String yearMonth ;
    private Integer salary ;
    @ManyToOne
    @JoinColumn(name = "muser_id")
    private MUser user;

    public Salary() {
    }

    public Salary(String yearMonth, Integer salary, MUser user) {
        this.yearMonth = yearMonth;
        this.salary = salary;
        this.user = user;
    }

    public Salary(String yearMonth, Integer salary) {
        this.yearMonth = yearMonth;
        this.salary = salary;
    }
    
    
}

