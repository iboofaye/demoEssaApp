package com.example.demoEssaApp;

import com.example.demoEssaApp.model.AppUser;
import com.example.demoEssaApp.model.Personne;
import com.example.demoEssaApp.repository.PersonneRepository;
import com.example.demoEssaApp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoEssaAppApplication {
    
    // private static final Logger log = LoggerFactory.getLogger(DemoEssaAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoEssaAppApplication.class, args);
                
	}
        
/*        
  @Bean
  public CommandLineRunner demo(UserRepository repository) {
    return (args) -> {
      // save a few users
      repository.save(new AppUser("Fallou", "fniang@essa.sn"));
      repository.save(new AppUser("Saliou", "sndiaye@essa.sn"));
      repository.save(new AppUser("Ousmane", "olo@essa.sn"));
      repository.save(new AppUser("Issa", "igaye@essa.sn"));
      repository.save(new AppUser("Michelle", "mdiouf@essa.sn"));
      repository.save(new AppUser("Fallou", "fciss@essa.sn"));
      repository.save(new AppUser("Fallou", "fdiop@essa.sn"));

      // fetch all users
      log.info("Users found with findAll():");
      log.info("-------------------------------");
      for (AppUser user : repository.findAll()) {
        log.info(user.toString());
      }
      log.info("");

      // fetch an individual user by ID
      AppUser user = repository.findById(1L);
      log.info("User found with findById(1L):");
      log.info("--------------------------------");
      log.info(user.toString());
      log.info("");

      // fetch customers by last name
      log.info("User found with findByName('Fallou'):");
      log.info("--------------------------------------------");
      repository.findByName("Fallou").forEach(fallou -> {
        log.info(fallou.toString());
      });
      // for (Customer bauer : repository.findByLastName("Bauer")) {
      //  log.info(bauer.toString());
      // }
      log.info("");
        
     // Save Personnes
        pr.save(new Personne("Oumar", "Ndiaye", 20));
        pr.save(new Personne("Anta", "Thiam", 30));
        pr.save(new Personne("Ousmane", "Fall", 10));
    };
  }*/

}
