package com.TourXpress.TourXpressApi.dto;

public class ServiceDTO {

  private Integer serviceID;
  private String description;

  public ServiceDTO(Integer serviceID, String description) {
    this.serviceID = serviceID;
    this.description = description;
  }

  public ServiceDTO() {
  }

  public Integer getServiceID() {
    return serviceID;
  }

  public void setServiceID(Integer serviceID) {
    this.serviceID = serviceID;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
