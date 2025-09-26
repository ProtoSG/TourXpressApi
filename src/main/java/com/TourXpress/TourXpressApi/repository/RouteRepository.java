package com.TourXpress.TourXpressApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TourXpress.TourXpressApi.domain.City;
import com.TourXpress.TourXpressApi.domain.Route;

public interface RouteRepository extends JpaRepository<Route, Integer> {

  @Query("SELECT DISTINCT r.originCity FROM Route r")
  List<City> findDistinctOriginCities();

  @Query("select r.destinationCity from Route r where r.originCity.cityID = :originCityId")
  List<City> findDestinationCitiesByOrogonCityId(@Param("originCityId") Integer originCityId);
}
