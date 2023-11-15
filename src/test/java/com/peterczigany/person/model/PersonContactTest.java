package com.peterczigany.person.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PersonContactTest {

  @Test
  void create() {
    PersonContact contact =
        new PersonContact(null, PersonContact.ContactType.EMAIL, "holly@black.com");

    assertThat(contact.getContactType()).isEqualTo(PersonContact.ContactType.EMAIL);
    assertThat(contact.getContactValue()).isEqualTo("holly@black.com");
  }
}
