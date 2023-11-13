package com.cg.hbm;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelBookingManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingManagementSystemApplication.class, args);
		System.out.println("---------------Success---------------");
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
