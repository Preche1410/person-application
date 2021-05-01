package com.precheflorian.person.application;

import com.precheflorian.person.application.model.Person;
import com.precheflorian.person.application.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PersonApplication {
  @Autowired
private PersonRepository personRepository;

public static void main(String[] args) {
  SpringApplication.run(PersonApplication.class,args);
}
@PostConstruct
private void initDb(){
  Person person1 = new Person();
  person1.setFirstName("Siim");
  person1.setLastName("Toomingas");

  Person person2 = new Person();
  person2.setFirstName("Siim");
  person2.setLastName("Tenno");

  Person person3 = new Person();
  person3.setFirstName("Preche");
  person3.setLastName("Florian");

  personRepository.save(person1);
  personRepository.save(person2);
  personRepository.save(person3);
}
}



