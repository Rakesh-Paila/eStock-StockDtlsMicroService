package com.estockStockDtls.estockStockDtlsservice.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estockStockDtls.estockStockDtlsservice.entity.StockDtls;
import com.estockStockDtls.estockStockDtlsservice.model.StockDtlsModel;
import com.estockStockDtls.estockStockDtlsservice.service.StockDtlsService;

@RestController
@CrossOrigin(
		   origins = {"*"}
		)
public class StockDtlsController {

	   @Autowired
	   StockDtlsService addStockService;


   @PostMapping({"/add"})
   public int addStock(@RequestBody StockDtls s) {
      return this.addStockService.addStock(s);
   }

   @GetMapping({"/get/{companycode}/{fromDate}/{toDate}"})
   public List<StockDtlsModel> getStockDtls(@PathVariable int companycode, @PathVariable String fromDate, @PathVariable String toDate) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd\'T\'HH:mm");
      LocalDateTime fDate = LocalDateTime.parse(fromDate, formatter);
      LocalDateTime tDate = LocalDateTime.parse(toDate, formatter);
      List<StockDtlsModel> list = this.addStockService.getStockDtls(companycode, fDate, tDate);
      return list;
   }

   @GetMapping({"/getLatestStock"})
   public float getLatestStockDtls(@RequestParam int companyCode) {
      return this.addStockService.getLatestStockDtls(companyCode);
   }

   @DeleteMapping({"/deleteStocks/{companyCode}"})
   public void deleteStock(@PathVariable int companyCode) {
      this.addStockService.deleteStocks(companyCode);
   }
}


