package com.example.demoEssaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoEssaApp.model.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

    //public void update(Personne p, Long id);
    
}
