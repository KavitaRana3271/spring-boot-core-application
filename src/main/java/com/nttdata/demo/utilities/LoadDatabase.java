package com.nttdata.demo.utilities;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nttdata.demo.entities.Employee;
import com.nttdata.demo.repositories.EmployeeRepository;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "SDET")));
      log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "SDE")));
    };
  }
}
