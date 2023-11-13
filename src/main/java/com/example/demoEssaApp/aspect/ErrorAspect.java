/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

/**
 *
 * @author LENOVO
 */
@Aspect
@Component
@Slf4j
public class ErrorAspect {
    @AfterThrowing (value = "execution(* *..*..*(..)) &&" + "(bean(*Controller) || bean(*Service) || bean(*Repository))" , throwing = "ex" )
    public void throwingNull(DataAccessException ex ) {
    // Exception handling (log output)
    log.error("DataAccessException has occurred" );
    }
}
