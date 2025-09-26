package com.TourXpress.TourXpressApi.service;

import org.springframework.stereotype.Service;

import com.TourXpress.TourXpressApi.domain.City;
import com.TourXpress.TourXpressApi.dto.CityDTO;

@Service
public class CityService {

  public City toEntity(CityDTO cityDTO) {
    return new City( 
      cityDTO.getCityID(),
      cityDTO.getName()
    );
  }

  public CityDTO toDTO(City city) {
    return new CityDTO(
        city.getCityID(),
        city.getName()
    );
  }
}
