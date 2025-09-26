package com.TourXpress.TourXpressApi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="terminal")
public class Terminal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_terminal")
  private Integer terminalID;

  @Column(name = "nombre")
  private String name;

 @Column(name = "ubicacion")
  private String location;

 public Terminal(Integer terminalID, String name, String location) {
  this.terminalID = terminalID;
  this.name = name;
  this.location = location;
 }

 public Terminal() {
 }

 public Integer getTerminalID() {
  return terminalID;
 }

 public void setTerminalID(Integer terminalID) {
  this.terminalID = terminalID;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getLocation() {
  return location;
 }

 public void setLocation(String location) {
  this.location = location;
 }
}
