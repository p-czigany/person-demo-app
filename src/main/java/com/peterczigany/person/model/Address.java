package com.peterczigany.person.model;

public class Address {
  private Long id;
  private String street;
  private String city;
  private String zipCode;

  public Address() {}

  public Address(Long id, String street, String city, String zipCode) {
    this.id = id;
    this.street = street;
    this.city = city;
    this.zipCode = zipCode;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
}
