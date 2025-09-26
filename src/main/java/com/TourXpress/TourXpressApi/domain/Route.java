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
@Table(name="ruta")
public class Route {
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ruta")
  private Integer routeID;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_ciudad_origen", referencedColumnName = "id_ciudad", nullable = false)
  private City originCity;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_ciudad_destino", referencedColumnName = "id_ciudad", nullable = false)
  private City destinationCity;

  @Column(name="precio")
  private Double price;

  public Route() {
  }

  public Route(Integer routeID, City originCity, City destinationCity, Double price) {
    this.routeID = routeID;
    this.originCity = originCity;
    this.destinationCity = destinationCity;
    this.price = price;
  }

  public Integer getRouteID() {
    return routeID;
  }

  public void setRouteID(Integer routeID) {
    this.routeID = routeID;
  }

  public City getOriginCity() {
    return originCity;
  }

  public void setOriginCity(City originCity) {
    this.originCity = originCity;
  }

  public City getDestinationCity() {
    return destinationCity;
  }

  public void setDestinationCity(City destinationCity) {
    this.destinationCity = destinationCity;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

}
