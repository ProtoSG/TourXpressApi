package com.TourXpress.TourXpressApi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "descuento")
public class Discount {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_descuento")
  private Integer discountID;

  @Column(name = "codigo")
  private String code;

  @Column(name = "monto")
  private Double amount;

  public Discount() {
  }

  public Discount(Integer discountID, String code, Double amount) {
    this.discountID = discountID;
    this.code = code;
    this.amount = amount;
  }

  public Integer getDiscountID() {
    return discountID;
  }

  public void setDiscountID(Integer discountID) {
    this.discountID = discountID;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }
}
