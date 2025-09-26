package com.TourXpress.TourXpressApi.dto;

public class TerminalDTO {

  private Integer terminalID;
  private String time;
  private String location;

  public TerminalDTO(Integer terminalID, String time, String location) {
    this.terminalID = terminalID;
    this.time = time;
    this.location = location;
  }

  public TerminalDTO() {
  }

  public Integer getTerminalID() {
    return terminalID;
  }

  public void setTerminalID(Integer terminalID) {
    this.terminalID = terminalID;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

}
