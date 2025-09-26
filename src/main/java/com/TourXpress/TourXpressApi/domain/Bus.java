package com.TourXpress.TourXpressApi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_bus")
  private Integer busID;

  @Column(name = "piso")
  private Integer floor;

  @Column(name = "capacidad")
  private Integer capacity;

  public Bus() {
  }

  public Bus(Integer busID, Integer floor, Integer capacity) {
    this.busID = busID;
    this.floor = floor;
    this.capacity = capacity;
  }

  public Integer getBusID() {
    return busID;
  }

  public void setBusID(Integer busID) {
    this.busID = busID;
  }

  public Integer getFloor() {
    return floor;
  }

  public void setFloor(Integer floor) {
    this.floor = floor;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }
}
