package com.peterczigany.person.repository;

import com.peterczigany.person.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {}
