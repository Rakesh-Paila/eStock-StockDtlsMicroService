package com.estockStockDtls.estockStockDtlsservice.model;

import java.time.LocalDateTime;

public class StockDtlsModel {

	 private int id;
	 private float stockPrice;
	 private LocalDateTime createDate;
	 private int companyCd;
	 
	public StockDtlsModel(int id, float stockPrice, LocalDateTime createDate, int companyCd) {
		super();
		this.id = id;
		this.stockPrice = stockPrice;
		this.createDate = createDate;
		this.companyCd = companyCd;
	}

	public StockDtlsModel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public int getcompanyCd() {
		return companyCd;
	}

	public void setcompanyCd(int companyCd) {
		this.companyCd = companyCd;
	}

	@Override
	public String toString() {
		return "StockDtlsModel [id=" + id + ", stockPrice=" + stockPrice + ", createDate=" + createDate + ", companyCd="
				+ companyCd + "]";
	}
	

	   
}
