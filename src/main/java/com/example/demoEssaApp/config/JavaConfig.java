/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author LENOVO
 */
@Configuration
public class JavaConfig {

    /**
     *
     * @return
     */
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}