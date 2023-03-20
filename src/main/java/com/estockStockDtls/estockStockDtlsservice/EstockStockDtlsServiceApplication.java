package com.estockStockDtls.estockStockDtlsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EstockStockDtlsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstockStockDtlsServiceApplication.class, args);
	}

}
