package com.TourXpress.TourXpressApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TourXpress.TourXpressApi.dto.SeatDTO;
import com.TourXpress.TourXpressApi.service.SeatService;

@RestController
@RequestMapping("/seat")
public class SeatController {
  
  private final SeatService seatService;

  public SeatController(SeatService seatService) {
    this.seatService = seatService;
  }

  @GetMapping("/bus/{id}")
  public ResponseEntity<?> getSeatsByBusID(@PathVariable Integer id) {
    List<SeatDTO> seats = seatService.getSeatByBusID(id);

    return ResponseEntity.ok(seats);
  }
  
}
