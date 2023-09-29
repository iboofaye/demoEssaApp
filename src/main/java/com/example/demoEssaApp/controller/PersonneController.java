package com.example.demoEssaApp.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoEssaApp.model.Personne;
import com.example.demoEssaApp.repository.PersonneRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("personne")
public class PersonneController {
	
	@Autowired
	private PersonneRepository pr;
        
        @PostMapping("/add")
        public String addPersonne(@RequestBody Personne personne){
            pr.save(personne);
            return "Saved !";
        }
	
	@GetMapping("/{id}")
	public String One( @PathVariable long id) {
		Optional<Personne> p = pr.findById(id);
		return p.toString();
		
	}
	@GetMapping("/all")
	public Iterable<Personne> all() {
		Iterable<Personne> all = pr.findAll();
		return all;
		
	} 
        
        @GetMapping("/delete/{id}")
        public String deletePersonne(@PathVariable Long id){
            pr.deleteById(id);
            return "deleted !";
        }
        
        @GetMapping("/update/{id}")
        public String updatePersonne(@PathVariable Long id, Personne p){
            //pr.update(p, id);
            return "deleted !";
        }
}
