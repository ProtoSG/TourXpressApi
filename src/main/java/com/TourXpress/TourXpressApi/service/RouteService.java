package com.TourXpress.TourXpressApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TourXpress.TourXpressApi.domain.City;
import com.TourXpress.TourXpressApi.dto.CityDTO;
import com.TourXpress.TourXpressApi.repository.RouteRepository;

@Service
public class RouteService {
  private final RouteRepository repo;
  private final CityService cityService;

  public RouteService(RouteRepository repo, CityService cityService) {
    this.repo = repo;
    this.cityService = cityService;
  }

  public List<CityDTO> getOriginCities() {
    List<City> cities = this.repo.findDistinctOriginCities();

    return cities.stream()
      .map(cityService::toDTO)
      .toList();
  }

  public List<CityDTO> getDestinationCities(Integer id) {
    List<City> cities = this.repo.findDestinationCitiesByOrogonCityId(id);

    return cities.stream()
      .map(cityService::toDTO)
      .toList();
  }
}
