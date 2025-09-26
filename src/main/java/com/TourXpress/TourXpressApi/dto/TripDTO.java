package com.TourXpress.TourXpressApi.dto;

public class TripDTO {

  private Integer tripID;
  private TerminalDTO boarding;
  private TerminalDTO disembarkation;
  private ServiceDTO service;
  private BusDTO bus;
  private Integer seatsAvailable;
  private Double price;

  public TripDTO(Integer tripID, TerminalDTO boarding, TerminalDTO disembarkation, ServiceDTO service, BusDTO bus,
      Integer seatsAvailable, Double price) {
    this.tripID = tripID;
    this.boarding = boarding;
    this.disembarkation = disembarkation;
    this.service = service;
    this.bus = bus;
    this.seatsAvailable = seatsAvailable;
    this.price = price;
  }

  public TripDTO() {
  }

  public Integer getTripID() {
    return tripID;
  }

  public void setTripID(Integer tripID) {
    this.tripID = tripID;
  }

  public TerminalDTO getBoarding() {
    return boarding;
  }

  public void setBoarding(TerminalDTO boarding) {
    this.boarding = boarding;
  }

  public TerminalDTO getDisembarkation() {
    return disembarkation;
  }

  public void setDisembarkation(TerminalDTO disembarkation) {
    this.disembarkation = disembarkation;
  }

  public ServiceDTO getService() {
    return service;
  }

  public void setService(ServiceDTO service) {
    this.service = service;
  }

  public BusDTO getBus() {
    return bus;
  }

  public void setBus(BusDTO bus) {
    this.bus = bus;
  }

  public Integer getSeatsAvailable() {
    return seatsAvailable;
  }

  public void setSeatsAvailable(Integer seatsAvailable) {
    this.seatsAvailable = seatsAvailable;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

}
