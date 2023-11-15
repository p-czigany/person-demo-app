package com.peterczigany.person;

import static org.assertj.core.api.Assertions.assertThat;

import com.peterczigany.person.model.Person;
import com.peterczigany.person.repository.PersonRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {
  @Mock private PersonRepository repository;
  @InjectMocks private PersonController controller;

  @Test
  void testGettingAllRecords() {
    List<Person> people = List.of(new Person(), new Person());
    Mockito.when(repository.findAll()).thenReturn(people);

    assertThat(controller.getAllPeople()).isEqualTo(people);
  }
}
