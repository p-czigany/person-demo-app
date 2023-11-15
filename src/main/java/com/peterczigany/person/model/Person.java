package com.peterczigany.person.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
  private List<PersonContact> contacts;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "permanent_address_id")
  private Address permanentAddress;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "temporary_address_id")
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
