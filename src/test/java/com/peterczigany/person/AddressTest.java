package com.peterczigany.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AddressTest {

  @Test
  void create() {
    Address address = new Address(null, "44 Bronson Lane", "Hensonville", "123321");

    assertThat(address.getStreet()).isEqualTo("44 Bronson Lane");
    assertThat(address.getCity()).isEqualTo("Hensonville");
    assertThat(address.getZipCode()).isEqualTo("123321");
  }
}
