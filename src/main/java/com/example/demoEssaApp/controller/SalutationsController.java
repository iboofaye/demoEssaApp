package com.example.demoEssaApp.controller;


import com.example.demoEssaApp.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoEssaApp.model.Salutation;
import com.example.demoEssaApp.service.SalutationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SalutationsController {

        @Autowired
        private SalutationsService service ;
        
	@GetMapping("/")
	public String salutations() {
		return "salut";
	}
        
        // [3]. Passing Values from One Screen to Another
        @PostMapping("/salut" )
        public String postRequest(@RequestParam ("text1" ) String str , Model model ) {
        // Register the string received from the screen to Model
        model.addAttribute("sample" , str );
        // Screen transition to response.html
        return "salut/reponse" ;
        }
        
        //[4] Gets a value from the database
        @PostMapping ("/salut/db" )
        public String postDbRequest(@RequestParam ("text2" ) String id , Model model ) {
            // Search one
            Employee employee = service.getEmployee(id );
            // Save Search Results to Model
            model.addAttribute("employee" , employee );
            // Screen transition to db.html
            return "salut/db" ;
        }
	
	@GetMapping("/salut/{nom}")
	public String salutation(@PathVariable String nom) {
		return "Bienvenue "+nom + " !!";
	}
	
	@GetMapping("/bean/inject")
	public String salut(Salutation s) {
		s.setFormuleInitial("Bonjour");
		s.setNomInterlocuteur(" Moussa ");
		return s.getFormuleInitial() + s.getNomInterlocuteur()+"!!";
	}
        
        @GetMapping("/simple/{formuleInitial}/{nomInterlocuteur}")
	public String afficherSalutations(@PathVariable String formuleInitial,
                                          @PathVariable String nomInterlocuteur) {
		return "indexJSP";
	}
        
        @GetMapping("/simple1/{formuleInitial}/{nomInterlocuteur}")
	public String afficherSalutations(Salutation s, Model model) {
		return "indexJSP1";
	}
        
        @GetMapping("/bonjour/{name}")
	public String direBonjour( @PathVariable String name, Model model) {
		model.addAttribute("name", name);
		return "bonjour";
	}
        
        @GetMapping("/bonsoir/{name}")
	public String direBonsoir(@PathVariable String name, Model model) {
		model.addAttribute("name", name);
		return "bonsoir";
	}

	
}
