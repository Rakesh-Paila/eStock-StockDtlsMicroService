package com.estockStockDtls.estockStockDtlsservice.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class StockDtlsSearch {

   private int companycode;
   @DateTimeFormat(
      iso = ISO.DATE_TIME
   )
   private LocalDateTime fromDate;
   @DateTimeFormat(
      iso = ISO.DATE_TIME
   )
   private LocalDateTime toDate;


   public int getCompanycode() {
      return this.companycode;
   }

   public void setCompanycode(int companycode) {
      this.companycode = companycode;
   }

   public LocalDateTime getFromDate() {
      return this.fromDate;
   }

   public void setFromDate(LocalDateTime fromDate) {
      this.fromDate = fromDate;
   }

   public LocalDateTime getToDate() {
      return this.toDate;
   }

   public void setToDate(LocalDateTime toDate) {
      this.toDate = toDate;
   }

   public String toString() {
      return "StockDtlsSearch [companycode=" + this.companycode + ", fromDate=" + this.fromDate + ", toDate=" + this.toDate + "]";
   }
}