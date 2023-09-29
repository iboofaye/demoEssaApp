/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.repository;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author iboofaye
 */

@Repository
public class SalutationsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate ;
    public Map<String, Object> findById(String id ) {
        // SELECT statement
        String query = "SELECT *" + " FROM employee" + " WHERE id=?" ;
        // Search execution
        Map<String, Object> employee = jdbcTemplate.queryForMap(query , id );
    return employee ;
    }
}
