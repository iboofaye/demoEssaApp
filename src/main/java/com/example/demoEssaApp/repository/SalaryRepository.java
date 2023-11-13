/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demoEssaApp.repository;

import com.example.demoEssaApp.domain.user.model.Salary;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LENOVO
 */
public interface SalaryRepository extends JpaRepository<Salary, Long>{

    public Salary findBySalaryId(String salaryId);
    //public List<Salary> findByUserId(String userId);
    
}
