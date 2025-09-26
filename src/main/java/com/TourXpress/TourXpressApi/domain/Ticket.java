package com.TourXpress.TourXpressApi.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "boleto")
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ticket")
  private Integer ticketID;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_pasajero", referencedColumnName = "id_pasajero", nullable = false)
  private Passenger passenger;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_viaje", referencedColumnName = "id_viaje", nullable = false)
  private Trip trip;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_asiento", referencedColumnName = "id_asiento", nullable = false)
  private Seat seat;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_transaccion", referencedColumnName = "id_transaccion", nullable = false)
  private Transaction transaction;

  @Column(name = "sub_total")
  private Double subtotal;

  @Column(name = "fecha_compra")
  private LocalDateTime pucharseDate;

  public Ticket(Integer ticketID, Trip trip, Seat seat, Transaction transaction, Double subtotal,
      LocalDateTime pucharseDate) {
    this.ticketID = ticketID;
    this.trip = trip;
    this.seat = seat;
    this.transaction = transaction;
    this.subtotal = subtotal;
    this.pucharseDate = pucharseDate;
  }

  public Ticket() {
  }

  public Integer getTicketID() {
    return ticketID;
  }

  public void setTicketID(Integer ticketID) {
    this.ticketID = ticketID;
  }

  public Trip getTrip() {
    return trip;
  }

  public void setTrip(Trip trip) {
    this.trip = trip;
  }

  public Seat getSeat() {
    return seat;
  }

  public void setSeat(Seat seat) {
    this.seat = seat;
  }

  public Transaction getTransaction() {
    return transaction;
  }

  public void setTransaction(Transaction transaction) {
    this.transaction = transaction;
  }

  public Double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Double subtotal) {
    this.subtotal = subtotal;
  }

  public LocalDateTime getPucharseDate() {
    return pucharseDate;
  }

  public void setPucharseDate(LocalDateTime pucharseDate) {
    this.pucharseDate = pucharseDate;
  }

}
