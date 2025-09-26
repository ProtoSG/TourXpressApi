package com.TourXpress.TourXpressApi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TourXpress.TourXpressApi.domain.Bus;
import com.TourXpress.TourXpressApi.domain.ServiceTerminal;
import com.TourXpress.TourXpressApi.domain.Terminal;
import com.TourXpress.TourXpressApi.domain.Trip;
import com.TourXpress.TourXpressApi.dto.BusDTO;
import com.TourXpress.TourXpressApi.dto.ServiceDTO;
import com.TourXpress.TourXpressApi.dto.TerminalDTO;
import com.TourXpress.TourXpressApi.dto.TripDTO;
import com.TourXpress.TourXpressApi.repository.TripRepository;

@Service
public class TripService  {
  private final TripRepository repo;

  public TripService(TripRepository repo) {
    this.repo = repo;
  }

  @Transactional(readOnly = true)
  public List<TripDTO> getByOriginCityDestinationCityDepartureDate(
      Integer originCityId,
      Integer destinationCityId,
      LocalDate departureDate
  ) {
    List<Trip> trips = this.repo.findByRouteOriginCityCityIDAndRouteDestinationCityCityIDAndDepartureDate(
        originCityId, 
        destinationCityId, 
        departureDate);
      
    return trips.stream()
      .map(this::toDto)
      .toList();
  
  }

  public TripDTO toDto(Trip trip) {
    var boarding = new TerminalDTO(
      trip.getBoardingTerminal().getTerminalID(), 
      trip.getBoardingTime(),
      trip.getBoardingTerminal().getLocation()
    );

    var disembarkation = new TerminalDTO(
      trip.getDisembarkationTerminal().getTerminalID(), 
      trip.getDisembarkationTime(),
      trip.getDisembarkationTerminal().getLocation()
    );

    var service = new ServiceDTO(
      trip.getService().getServiceID(),
      trip.getService().getDescription()
    );

    var bus = new BusDTO(
      trip.getBus().getBusID(), 
      trip.getBus().getFloor()
    );

    return new TripDTO(
      trip.getTripID(), 
      boarding,
      disembarkation,
      service,
      bus,
      trip.getSeatsAvailable(),
      trip.getTripPrice()
    );
  }

  public Trip toEntity(TripDTO tripDTO) {
    Trip trip = new Trip();
    trip.setTripID(tripDTO.getTripID());
    trip.setSeatsAvailable(tripDTO.getSeatsAvailable());
    trip.setTripPrice(tripDTO.getPrice());

    Terminal boarding = new Terminal();
    boarding.setTerminalID(tripDTO.getBoarding().getTerminalID());
    trip.setBoardingTerminal(boarding);

    Terminal disembarkation = new Terminal();
    disembarkation.setTerminalID(tripDTO.getDisembarkation().getTerminalID());
    trip.setDisembarkationTerminal(disembarkation);
  
    ServiceTerminal service = new ServiceTerminal();
    service.setServiceID(tripDTO.getService().getServiceID());
    trip.setService(service);

    Bus bus = new Bus();
    bus.setBusID(tripDTO.getBus().getBusID());
    trip.setBus(bus);

    return trip;
  }
}
