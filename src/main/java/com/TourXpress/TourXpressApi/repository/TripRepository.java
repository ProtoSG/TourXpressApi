package com.TourXpress.TourXpressApi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TourXpress.TourXpressApi.domain.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
  List<Trip> findByRouteOriginCityCityIDAndRouteDestinationCityCityIDAndDepartureDate(
      Integer originCityId,
      Integer destinationCityId,
      LocalDate departureDate
  );
}
