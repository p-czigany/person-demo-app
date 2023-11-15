package com.peterczigany.person.model;

public class PersonContact {
  private Long id;
  private ContactType contactType;
  private String contactValue;

  public enum ContactType {
    PHONE,
    EMAIL
  }

  public PersonContact() {}

  public PersonContact(Long id, ContactType contactType, String contactValue) {
    this.id = id;
    this.contactType = contactType;
    this.contactValue = contactValue;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ContactType getContactType() {
    return contactType;
  }

  public void setContactType(ContactType contactType) {
    this.contactType = contactType;
  }

  public String getContactValue() {
    return contactValue;
  }

  public void setContactValue(String contactValue) {
    this.contactValue = contactValue;
  }
}
