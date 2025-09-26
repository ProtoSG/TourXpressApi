package com.TourXpress.TourXpressApi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudad")
public class City {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ciudad")
  private Integer cityID;

  @Column(name = "nombre")
  private String name;

  public City() {}

  public City(Integer cityID, String name) {
    this.cityID = cityID;
    this.name = name;
  }

  public Integer getCityID() {
    return cityID;
  }

  public void setCityID(Integer cityID) {
    this.cityID = cityID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
