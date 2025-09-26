package com.TourXpress.TourXpressApi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TourXpress.TourXpressApi.dto.CityDTO;
import com.TourXpress.TourXpressApi.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {

  private final RouteService routeService;

  public RouteController(RouteService routeService) {
    this.routeService = routeService;
  }

  @GetMapping("/origins-city")
  public ResponseEntity<?> getAllOriginCities() {
    List<CityDTO> cities = routeService.getOriginCities();

    return ResponseEntity.ok(cities);
  }

  @GetMapping("/destinations-city/{id}")
  public ResponseEntity<?> getAllDestinationsCities(@PathVariable Integer id) {
    List<CityDTO> cities = routeService.getDestinationCities(id);

    return ResponseEntity.ok(cities);
  }
}
