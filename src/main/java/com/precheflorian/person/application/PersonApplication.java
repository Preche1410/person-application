package com.precheflorian.person.application;

import com.precheflorian.person.application.model.Person;
import com.precheflorian.person.application.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PersonApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
    SpringApplication.run(PersonApplication.class, args);
		PersonRepository personRepository = configurableApplicationContext.getBean(PersonRepository.class);
		Person myPerson = new Person("Siim", "Toomingas");
		personRepository.save(myPerson);
	}

}
