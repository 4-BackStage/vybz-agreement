package com.vybz.agreement_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableDiscoveryClient
@SpringBootApplication
public class AgreementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgreementServiceApplication.class, args);
	}

}
