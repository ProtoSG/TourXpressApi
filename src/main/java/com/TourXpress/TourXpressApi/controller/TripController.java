package com.TourXpress.TourXpressApi.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TourXpress.TourXpressApi.dto.TripDTO;
import com.TourXpress.TourXpressApi.service.TripService;

@RestController
@RequestMapping("/trip")
public class TripController {

  private final TripService tripService;

  public TripController(TripService tripService) {
    this.tripService = tripService;
  }

  @GetMapping()
  public ResponseEntity<?> getTripsByOriginCityDestinationCityDepartureDate(
    @RequestParam() Integer origin,
    @RequestParam() Integer destination,
    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
  ) {
    List<TripDTO> tripsDTO = tripService
      .getByOriginCityDestinationCityDepartureDate(origin, destination, date);

    return ResponseEntity.ok(tripsDTO);
  }
}
