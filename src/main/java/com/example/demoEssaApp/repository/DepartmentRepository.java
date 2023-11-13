/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.repository;

import com.example.demoEssaApp.domain.user.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author LENOVO
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    public Department findByDepartmentName(String departmentName);
}
