package com.estockStockDtls.estockStockDtlsservice.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(
   name = "STOCK_DTLS"
)
public class StockDtls {

   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private int id;
   @Column(
      name = "stock_price"
   )
   private float stockPrice;
   @Column(
      name = "create_dt"
   )
   private LocalDateTime createDate;
   @Column(
      name = "company_code"
   )
   private int company_cd;


   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public float getStockPrice() {
      return this.stockPrice;
   }

   public void setStockPrice(float stockPrice) {
      this.stockPrice = stockPrice;
   }

   public LocalDateTime getCreateDate() {
      return this.createDate;
   }

   public void setCreateDate(LocalDateTime createDate) {
      this.createDate = createDate;
   }

   public int getCompany_cd() {
      return this.company_cd;
   }

   public void setCompany_cd(int company_cd) {
      this.company_cd = company_cd;
   }

   public String toString() {
      return "StockDtls [id=" + this.id + ", stockPrice=" + this.stockPrice + ", createDate=" + this.createDate + ", company_cd=" + this.company_cd + "]";
   }
}
