package com.simple.flightSearch.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class FlightSearchRequest {
	
	private String flightNumber;
	private String origin;
	private String destination;
	private java.time.LocalDate date;
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	

}
