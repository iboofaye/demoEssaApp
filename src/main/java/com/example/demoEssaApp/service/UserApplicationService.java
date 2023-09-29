/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */

@Service
public class UserApplicationService {
    
    @Autowired
    private MessageSource messageSource ;
    /** Generate a gender Map
     * @param locale
     * @return  */
    public Map<String, Integer> getGenderMapMessage(Locale locale) {
        Map<String, Integer> genderMap = new LinkedHashMap<>();
        String male = messageSource.getMessage("male" , null , Locale.ENGLISH );
        String female = messageSource.getMessage("female" , null , Locale.ENGLISH );
        genderMap.put(male , 1);
        genderMap.put(female , 2);
        return genderMap ;
    }
    /** Generate a gender Map
     * @return  */
    public Map<String, Integer> getGenderMap() {
        Map<String, Integer> genderMap = new LinkedHashMap<>();
        genderMap.put("male" , 1);
        genderMap.put("female" , 2);
        return genderMap ;
    }
}
