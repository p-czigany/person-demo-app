package com.peterczigany.person;

import com.peterczigany.person.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {}
