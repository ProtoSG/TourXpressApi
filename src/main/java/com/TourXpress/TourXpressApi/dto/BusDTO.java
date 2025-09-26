package com.TourXpress.TourXpressApi.dto;

public class BusDTO {

  private Integer busID;
  private Integer floorNumbers;

  public BusDTO(Integer busID, Integer floorNumbers) {
    this.busID = busID;
    this.floorNumbers = floorNumbers;
  }

  public BusDTO() {
  }

  public Integer getBusID() {
    return busID;
  }

  public void setBusID(Integer busID) {
    this.busID = busID;
  }

  public Integer getFloorNumbers() {
    return floorNumbers;
  }

  public void setFloorNumbers(Integer floorNumbers) {
    this.floorNumbers = floorNumbers;
  }

}

