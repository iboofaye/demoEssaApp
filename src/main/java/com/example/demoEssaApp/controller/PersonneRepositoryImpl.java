/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.controller;

import com.example.demoEssaApp.model.Personne;
import com.example.demoEssaApp.repository.PersonneRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author LENOVO
 */
public abstract class PersonneRepositoryImpl implements PersonneRepository{
    
    //@Autowired
    //private PersonneRepository pr;

    /*@Override
    public void update(Personne p, Long id) {
        Personne prs = pr.findById(id).get();
        prs.setNom(p.getNom());
        prs.setPrenom(p.getPrenom());
        prs.setAge(p.getAge());
        pr.save(prs);
    }*/
    
}
