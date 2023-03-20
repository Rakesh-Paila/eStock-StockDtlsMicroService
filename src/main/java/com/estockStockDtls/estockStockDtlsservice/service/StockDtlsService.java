package com.estockStockDtls.estockStockDtlsservice.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estockStockDtls.estockStockDtlsservice.entity.StockDtls;
import com.estockStockDtls.estockStockDtlsservice.model.StockDtlsModel;
import com.estockStockDtls.estockStockDtlsservice.repository.StockDtlsRepo;

@Service
public class StockDtlsService {

   @Autowired
   StockDtlsRepo stockDtlsRepo;


   public int addStock(StockDtls s) {
      s.setCreateDate(LocalDateTime.now());
      StockDtls sd = (StockDtls)this.stockDtlsRepo.save(s);
      return sd.getId();
   }

   public void deleteStocks(int companyCode) {
      List sDtls = this.stockDtlsRepo.getStockByCompanyCode(companyCode);
      if(sDtls.size() != 0) {
         Iterator var4 = sDtls.iterator();

         while(var4.hasNext()) {
            StockDtls s = (StockDtls)var4.next();
            this.stockDtlsRepo.deleteById(Integer.valueOf(s.getId()));
         }
      }

   }

   public List<StockDtlsModel> getStockDtls(int companyCode, LocalDateTime starDate, LocalDateTime endDate) {
	   System.out.println("staDate :"+starDate);
	   System.out.println("endDate :"+endDate);
	   //return 
	   List<StockDtlsModel> stkList = new ArrayList<>();
	   
	   List listObj = this.stockDtlsRepo.getStockDtls(companyCode, starDate, endDate);
	   Iterator var5 = listObj.iterator();
	      while(var5.hasNext()) {
	    	 StockDtlsModel stk = new StockDtlsModel();
	         Object[] rs = (Object[])var5.next();
	         int code = ((Integer)rs[0]).intValue();
	         int companyCd =((Integer)rs[1]).intValue();
	         Timestamp createDate = (Timestamp)rs[2];
	         Float stockPrice = (Float)rs[3];
	         stk.setId(code);
	         stk.setcompanyCd(companyCd);
	         stk.setCreateDate(createDate.toLocalDateTime());
	         stk.setStockPrice(stockPrice.floatValue());
	         
	         stkList.add(stk);
	      }

	      return stkList;
   }

   public float getLatestStockDtls(int companyCode) {
      StockDtls s = this.stockDtlsRepo.getLatestStockByCompanyCode(companyCode);
      return Objects.isNull(s)?0.0F:s.getStockPrice();
   }
}
