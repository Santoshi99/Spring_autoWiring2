package com.infy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.infy.repository.InsuranceRepositoryImpl;
import com.infy.service.InsuranceServiceImpl;

@Configuration
@PropertySource("classpath:messages.properties")
public class SpringConfig {
	
	@Bean
	public InsuranceServiceImpl insuranceService() {
		
		return new InsuranceServiceImpl();
	}
	@Bean
	public InsuranceRepositoryImpl insuranceRepository() {
		
		return new InsuranceRepositoryImpl();
	}

}