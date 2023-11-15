package com.peterczigany.person;

import static org.assertj.core.api.Assertions.assertThat;

import com.peterczigany.person.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PersonRepositoryTest {

  @Autowired PersonRepository repository;

  @Test
  void findAll() {
    repository.save(new Person());
    repository.save(new Person());

    assertThat(repository.findAll()).hasSize(2);
  }
}
