package com.peterczigany.person.model;

import java.util.List;

public class Person {
  private Long id;
  private String name;
  private List<PersonContact> contacts;
  private Address permanentAddress;
  private Address temporaryAddress;

  public Person() {}

  public Person(
      Long id,
      String name,
      List<PersonContact> contacts,
      Address permanentAddress,
      Address temporaryAddress) {
    this.id = id;
    this.name = name;
    this.contacts = contacts;
    this.permanentAddress = permanentAddress;
    this.temporaryAddress = temporaryAddress;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<PersonContact> getContacts() {
    return contacts;
  }

  public void setContacts(List<PersonContact> contacts) {
    this.contacts = contacts;
  }

  public Address getPermanentAddress() {
    return permanentAddress;
  }

  public void setPermanentAddress(Address permanentAddress) {
    this.permanentAddress = permanentAddress;
  }

  public Address getTemporaryAddress() {
    return temporaryAddress;
  }

  public void setTemporaryAddress(Address temporaryAddress) {
    this.temporaryAddress = temporaryAddress;
  }
}
