/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demoEssaApp.repository;

import com.example.demoEssaApp.model.AppUser;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author LENOVO
 */
public interface UserRepository extends CrudRepository<AppUser, Integer>{

    public AppUser findById(long l);

    public List<AppUser> findByName(String email);
    
}
