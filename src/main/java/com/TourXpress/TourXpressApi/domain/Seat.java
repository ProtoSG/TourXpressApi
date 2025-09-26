package com.TourXpress.TourXpressApi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asiento")
public class Seat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id_asiento")
  private Integer seatID;
   
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_bus", referencedColumnName = "id_bus", nullable = false)
  private Bus bus;

  @Column(name = "numero_asiento")
  private Integer seatNumber;

  @Column(name = "piso")
  private Integer floor;

  @Column(name = "precio")
  private Double price;

  @Column(name = "disponible")
  private Boolean available;

  public Seat() {
  }

  public Seat(Integer seatID, Bus bus, Integer seatNumber, Integer floor, Double price, Boolean available) {
    this.seatID = seatID;
    this.bus = bus;
    this.seatNumber = seatNumber;
    this.floor = floor;
    this.price = price;
    this.available = available;
  }

  public Integer getSeatID() {
    return seatID;
  }

  public void setSeatID(Integer seatID) {
    this.seatID = seatID;
  }

  public Bus getBus() {
    return bus;
  }

  public void setBus(Bus bus) {
    this.bus = bus;
  }

  public Integer getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(Integer seatNumber) {
    this.seatNumber = seatNumber;
  }

  public Integer getFloor() {
    return floor;
  }

  public void setFloor(Integer floor) {
    this.floor = floor;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Boolean getAvailable() {
    return available;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }
}
