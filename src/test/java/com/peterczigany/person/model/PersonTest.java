package com.peterczigany.person.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.peterczigany.person.model.PersonContact.ContactType;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PersonTest {

  @Test
  void create() {
    PersonContact email = new PersonContact(null, ContactType.EMAIL, "holly@black.com");
    PersonContact phone = new PersonContact(null, ContactType.PHONE, "+424242424242");
    Address permanentAddress = new Address(null, "44 Bronson Lane", "Hensonville", "123321");
    Address temporaryAddress = new Address(null, "742 Evergreen Terrace", "Springfield", "321123");

    Person person =
        new Person(null, "Holly Black", List.of(phone, email), permanentAddress, temporaryAddress);

    assertThat(person.getName()).isEqualTo("Holly Black");
    assertThat(person.getContacts()).isEqualTo(List.of(phone, email));
    assertThat(person.getPermanentAddress().getStreet()).isEqualTo("44 Bronson Lane");
    assertThat(person.getTemporaryAddress().getCity()).isEqualTo("Springfield");
  }
}
