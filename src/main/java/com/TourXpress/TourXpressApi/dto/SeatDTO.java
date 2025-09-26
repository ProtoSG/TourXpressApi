package com.TourXpress.TourXpressApi.dto;


public class SeatDTO {

  private Integer seatID;
  private Integer busID;
  private Integer seatNumber;
  private Integer floor;
  private Double price;
  private Boolean available;

  public SeatDTO(Integer seatID, Integer busID, Integer seatNumber, Integer floor, Double price, Boolean available) {
    this.seatID = seatID;
    this.busID = busID;
    this.seatNumber = seatNumber;
    this.floor = floor;
    this.price = price;
    this.available = available;
  }

  public SeatDTO() {
  }

  public Integer getSeatID() {
    return seatID;
  }

  public void setSeatID(Integer seatID) {
    this.seatID = seatID;
  }

  public Integer getBusID() {
    return busID;
  }

  public void setBusID(Integer busID) {
    this.busID = busID;
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
