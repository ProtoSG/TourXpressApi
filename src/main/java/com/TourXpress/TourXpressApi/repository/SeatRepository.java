package com.TourXpress.TourXpressApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TourXpress.TourXpressApi.domain.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

  List<Seat> findByBusBusID(Integer busID);

}
