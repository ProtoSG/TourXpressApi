package com.TourXpress.TourXpressApi.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "viaje")
public class Trip {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_viaje")
  private Integer tripID;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta", nullable = false)
  private Route route;

  @Column(name = "fecha_salida")
  private LocalDate departureDate;

  @Column(name = "hora_embarque")
  private String boardingTime;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_terminal_embarque", referencedColumnName = "id_terminal", nullable = false)
  private Terminal boardingTerminal;

  @Column(name = "hora_desembarque")
  private String disembarkationTime;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_terminal_desembarque", referencedColumnName = "id_terminal", nullable = false)
  private Terminal disembarkationTerminal;

  @Column(name = "estado")
  private String state;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", nullable = false)
  private ServiceTerminal service;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_bus", referencedColumnName = "id_bus", nullable = false)
  private Bus bus;

  @Column(name = "precio_viaje")
  private Double tripPrice;

  @Column(name = "asientos_disponibles")
  private Integer seatsAvailable;

  public Trip(Integer tripID, Route route, LocalDate departureDate, String boardingTime, Terminal boardingTerminal,
      String disembarkationTime, Terminal disembarkationTerminal, String state, ServiceTerminal service, Bus bus,
      Double tripPrice, Integer seatsAvailable) {
    this.tripID = tripID;
    this.route = route;
    this.departureDate = departureDate;
    this.boardingTime = boardingTime;
    this.boardingTerminal = boardingTerminal;
    this.disembarkationTime = disembarkationTime;
    this.disembarkationTerminal = disembarkationTerminal;
    this.state = state;
    this.service = service;
    this.bus = bus;
    this.tripPrice = tripPrice;
    this.seatsAvailable = seatsAvailable;
  }

  public Trip() {
  }

  public Integer getTripID() {
    return tripID;
  }

  public void setTripID(Integer tripID) {
    this.tripID = tripID;
  }

  public Route getRoute() {
    return route;
  }

  public void setRoute(Route route) {
    this.route = route;
  }

  public LocalDate getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(LocalDate departureDate) {
    this.departureDate = departureDate;
  }

  public String getBoardingTime() {
    return boardingTime;
  }

  public void setBoardingTime(String boardingTime) {
    this.boardingTime = boardingTime;
  }

  public Terminal getBoardingTerminal() {
    return boardingTerminal;
  }

  public void setBoardingTerminal(Terminal boardingTerminal) {
    this.boardingTerminal = boardingTerminal;
  }

  public String getDisembarkationTime() {
    return disembarkationTime;
  }

  public void setDisembarkationTime(String disembarkationTime) {
    this.disembarkationTime = disembarkationTime;
  }

  public Terminal getDisembarkationTerminal() {
    return disembarkationTerminal;
  }

  public void setDisembarkationTerminal(Terminal disembarkationTerminal) {
    this.disembarkationTerminal = disembarkationTerminal;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public ServiceTerminal getService() {
    return service;
  }

  public void setService(ServiceTerminal service) {
    this.service = service;
  }

  public Bus getBus() {
    return bus;
  }

  public void setBus(Bus bus) {
    this.bus = bus;
  }

  public Double getTripPrice() {
    return tripPrice;
  }

  public void setTripPrice(Double tripPrice) {
    this.tripPrice = tripPrice;
  }

  public Integer getSeatsAvailable() {
    return seatsAvailable;
  }

  public void setSeatsAvailable(Integer seatsAvailable) {
    this.seatsAvailable = seatsAvailable;
  }
}

