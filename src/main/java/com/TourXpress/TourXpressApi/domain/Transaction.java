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
@Table(name = "transaccion")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_transaccion")
  private Integer transactionID;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
  private Customer customer;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_descuento", referencedColumnName = "id_descuento", nullable = false)
  private Discount discount;

  @Column(name = "total")
  private Double total;

  @Column(name = "metodo_pago")
  private String paymentMethod;

  @Column(name = "estado")
  private String state;

  @Column(name = "fecha_transaccion")
  private LocalDateTime transactionDate;

  public Transaction(Integer transactionID, Customer customer, Discount discount, Double total, String paymentMethod,
      String state, LocalDateTime transactionDate) {
    this.transactionID = transactionID;
    this.customer = customer;
    this.discount = discount;
    this.total = total;
    this.paymentMethod = paymentMethod;
    this.state = state;
    this.transactionDate = transactionDate;
  }

  public Transaction() {
  }

  public Integer getTransactionID() {
    return transactionID;
  }

  public void setTransactionID(Integer transactionID) {
    this.transactionID = transactionID;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Discount getDiscount() {
    return discount;
  }

  public void setDiscount(Discount discount) {
    this.discount = discount;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public String getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public LocalDateTime getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(LocalDateTime transactionDate) {
    this.transactionDate = transactionDate;
  }
  
}
