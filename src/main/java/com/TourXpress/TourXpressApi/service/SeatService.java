package com.TourXpress.TourXpressApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.TourXpress.TourXpressApi.domain.Seat;
import com.TourXpress.TourXpressApi.dto.SeatDTO;
import com.TourXpress.TourXpressApi.repository.SeatRepository;

@Service
public class SeatService {

  private final SeatRepository repository;

  public SeatService(SeatRepository repository) {
    this.repository = repository;
  }

  public List<SeatDTO> getSeatByBusID(Integer busID) {
    List<Seat> seats = repository.findByBusBusID(busID);

    return seats.stream()
      .map(this::toDTO)
      .toList();
  }

  public Seat toEntity(SeatDTO seatDTO) {
    Seat seat = new Seat();
    seat.setSeatID(seatDTO.getSeatID());
    seat.setSeatNumber(seatDTO.getSeatNumber());
    seat.setFloor(seatDTO.getFloor());
    seat.setPrice(seatDTO.getPrice());
    seat.setAvailable(seatDTO.getAvailable());

    return seat;
  }  

  public SeatDTO toDTO(Seat seat) {
    SeatDTO seatDTO = new SeatDTO();
    seatDTO.setSeatID(seat.getSeatID());
    seatDTO.setBusID(seat.getBus().getBusID());
    seatDTO.setSeatNumber(seat.getSeatNumber());
    seatDTO.setFloor(seat.getFloor());
    seatDTO.setPrice(seat.getPrice());
    seatDTO.setAvailable(seat.getAvailable());

    return seatDTO;
  }
}
