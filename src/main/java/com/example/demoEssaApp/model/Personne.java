package com.example.demoEssaApp.model;

import org.springframework.context.annotation.ComponentScan;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
@ComponentScan
public class Personne implements Serializable{
    
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String prenom;
	private String nom;
	private int age;

    public Personne(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }

    public Personne(long id, String prenom, String nom, int age) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }
    
    

    public Personne() {
    }
        
        
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", age=" + age + '}';
    }
	
	
}
