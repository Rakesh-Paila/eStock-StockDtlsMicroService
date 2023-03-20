package com.estockStockDtls.estockStockDtlsservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estockStockDtls.estockStockDtlsservice.entity.StockDtls;

public interface StockDtlsRepo extends JpaRepository <StockDtls, Integer>{

   @Query(
      value = "SELECT S.* FROM stock_dtls S WHERE S.COMPANY_CODE = ?1",
      nativeQuery = true
   )
   List getStockByCompanyCode(int var1);

   @Query(
      value = " SELECT s.* FROM stock_dtls s where s.company_code= ?1 ORDER BY s.id DESC LIMIT 1;",
      nativeQuery = true
   )
   StockDtls getLatestStockByCompanyCode(int var1);

   @Query(
      value = "SELECT S.* FROM stock_dtls S WHERE S.company_code = ?1 and S.create_dt BETWEEN (?2) and (?3)",
      nativeQuery = true
   )
   List getStockDtls(int var1, LocalDateTime var2, LocalDateTime var3);
}
