package com.precheflorian.person.application.controllers;


import com.precheflorian.person.application.exceptions.ResourceNotFoundException;
import com.precheflorian.person.application.model.Person;
import com.precheflorian.person.application.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins="http://localhost:8888")
@RestController
@RequestMapping("/api/person")

public class PersonController{

  @Autowired
private PersonRepository personRepository;

  @GetMapping
  public List<Person> getAllPersons(){
    return personRepository.findAll();
  }


  @GetMapping("/{id}")
  public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId){

    Person person = personRepository.findById(personId)
                  .orElseThrow(() -> new NoSuchElementException("Person not available for Id :"+personId));

    return ResponseEntity.ok().body(person);
  }

@PostMapping
public Person createPerson(@Validated @RequestBody Person person) throws ResourceNotFoundException{
  System.out.println(person);//Just to inspect values
  return personRepository.save(person);
}

}
