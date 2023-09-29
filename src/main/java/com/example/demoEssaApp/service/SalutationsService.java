/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.service;

import com.example.demoEssaApp.model.Employee;
import com.example.demoEssaApp.repository.SalutationsRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */

@Service
public class SalutationsService {
    @Autowired
    private SalutationsRepository repository ;
    /** Get one employee */
    public Employee getEmployee(String id) {
            // Search
            Map<String, Object> map = repository.findById(id );
            // Get value from Map
            String employeeId = (String) map .get("id" );
            String name = (String) map .get("name" );
            int age = (Integer) map.get("age" );
            // Set the Employee class to a value
            Employee employee = new Employee();
            employee.setEmployeeId(employeeId );
            employee.setEmployeeName(name );
            employee.setEmployeeAge(age );
            
            return employee;
    }
}
