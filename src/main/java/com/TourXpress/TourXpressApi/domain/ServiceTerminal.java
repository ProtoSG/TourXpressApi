package com.TourXpress.TourXpressApi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public class ServiceTerminal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_servicio")
  private Integer serviceID;

  @Column(name = "precio")
  private Double price;

  @Column(name = "descripcion")
  private String description;

  public ServiceTerminal() {
  }

  public ServiceTerminal(Integer serviceID, Double price, String description) {
    this.serviceID = serviceID;
    this.price = price;
    this.description = description;
  }

  public Integer getServiceID() {
    return serviceID;
  }

  public void setServiceID(Integer serviceID) {
    this.serviceID = serviceID;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
