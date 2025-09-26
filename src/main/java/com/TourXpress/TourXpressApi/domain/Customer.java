package com.TourXpress.TourXpressApi.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_cliente")
  private Integer customerID;

  @Column(name = "nombre")
  private String name;

  @Column(name = "apellido")
  private String lastName;

  @Column(name = "fecha_nacimiento")
  private LocalDate dateOfBirth;

  @Column(name = "sexo")
  private String gender;

  @Column(name = "dni")
  private String dni;

  @Column(name = "email")
  private String email;

  @Column(name = "telefono")
  private String phone;

  public Customer() {
  }

  public Customer(Integer customerID, String name, String lastName, LocalDate dateOfBirth, String gender, String dni,
      String email, String phone) {
    this.customerID = customerID;
    this.name = name;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.dni = dni;
    this.email = email;
    this.phone = phone;
  }

  public Integer getCustomerID() {
    return customerID;
  }

  public void setCustomerID(Integer customerID) {
    this.customerID = customerID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
