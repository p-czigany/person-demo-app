package com.peterczigany.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PersonContactTest {

  @Test
  void create() {
    PersonContact contact = new PersonContact(null, PersonContact.ContactType.EMAIL, "holly@black.com");

    assertThat(contact.getContactType()).isEqualTo(PersonContact.ContactType.EMAIL);
    assertThat(contact.getContactValue()).isEqualTo("holly@black.com");
  }
}
