package com.peterczigany.person;

import com.peterczigany.person.model.Person;
import com.peterczigany.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

  @Autowired PersonRepository repository;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Iterable<Person> getAllPeople() {
    return repository.findAll();
  }
}
