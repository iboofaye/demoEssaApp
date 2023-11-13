package com.example.demoEssaApp;

import com.example.demoEssaApp.domain.user.model.Department;
import com.example.demoEssaApp.domain.user.model.MUser;
import com.example.demoEssaApp.domain.user.model.Salary;
import com.example.demoEssaApp.model.AppUser;
import com.example.demoEssaApp.model.Personne;
import com.example.demoEssaApp.repository.PersonneRepository;
import com.example.demoEssaApp.mapper.UserMapper;
import com.example.demoEssaApp.repository.DepartmentRepository;
import com.example.demoEssaApp.repository.MUserRepository;
import com.example.demoEssaApp.repository.SalaryRepository;
import com.example.demoEssaApp.repository.UserRepository;
import static java.lang.Math.log;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import lombok.extern.slf4j.Slf4j;
import static org.hibernate.internal.CoreLogging.logger;

@SpringBootApplication
//@MapperScan("com.example.demoEssaApp")
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
     @Bean
  public CommandLineRunner departementdemo(DepartmentRepository repository) {
    return (args) -> {
      // save a few department
      repository.save(new Department("Info"));
      repository.save(new Department("RH"));
      repository.save(new Department("Finance"));
      repository.save(new Department("Com"));
      
    };
  }   
    @Bean
  public CommandLineRunner demo(MUserRepository repository, DepartmentRepository depRepository) {
    return (args) -> {
      // save a few users
      Department dep = depRepository.findByDepartmentName("RH");
      repository.save(new MUser("fee@hg.dn", "passer123", "amy", null, 22,1,"Admin", dep));
      Department dep1 = depRepository.findByDepartmentName("Info");
      repository.save(new MUser("tres@hg.sn", "passer123", "bitz", null, 22, 1,"Admin", dep1));
      repository.save(new MUser("igaye@essa.sn", "passer123", "issa", null, 22,  1,"Admin"));
      repository.save(new MUser("mdiouf@essa.sn", "passer123", "michelle", null, 22,  1,"Admin"));
      repository.save(new MUser("fciss@essa.sn", "passer123", "fallou", null, 22, 1, "Admin"));
      repository.save(new MUser("mdiouf@essa.sn", "passer123", "fallou", null, 22, 1, "Admin"));
      repository.save(new MUser("mdiouf@essa.sn", "passer123", "amy", null, 22,  1, "Admin"));

    };
  }
  
  @Bean
  public CommandLineRunner demoSalaire(SalaryRepository srepository, MUserRepository uRepository) {
    return (args) -> {
      // save a few users
      MUser us1 = uRepository.findByUserId("fee@hg.dn");
      srepository.save(new Salary("01/01", 1000, us1));
      srepository.save(new Salary("01/12", 1000, us1));
      srepository.save(new Salary("01/11", 1000, us1));
      //MUser us2 = uRepository.findByUserId("tres@hg.sn");
      //srepository.save(new Salary("01/09", 6000, us2));
      //MUser us3 = uRepository.findByUserId("igaye@essa.sn");
      //srepository.save(new Salary("14/10", 8000, us3));
      //MUser us4 = uRepository.findByUserId("mdiouf@essa.sn");
      //srepository.save(new Salary("11/11", 10000, us4));
     

    };
  }

}
