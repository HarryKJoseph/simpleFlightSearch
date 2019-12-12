package com.simple.flightSearch.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.simple.flightSearch"})
public class SimpleFlightSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleFlightSearchApplication.class, args);
	}

}
