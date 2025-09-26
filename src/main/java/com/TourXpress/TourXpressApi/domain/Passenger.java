package com.TourXpress.TourXpressApi.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pasajero")
public class Passenger {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_pasajero")
  private Integer passengerID;

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

  public Passenger(Integer passengerID, String name, String lastName, LocalDate dateOfBirth, String gender,
      String dni) {
    this.passengerID = passengerID;
    this.name = name;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.dni = dni;
  }

  public Passenger() {
  }

  public Integer getPassengerID() {
    return passengerID;
  }

  public void setPassengerID(Integer passengerID) {
    this.passengerID = passengerID;
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
  
}
