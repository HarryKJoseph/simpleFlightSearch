package com.simple.flightSearch.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.simple.flightSearch.dto.FlightSearchRequest;
import com.simple.flightSearch.model.FlightDetails;

@Service
public interface FlightSearchService {
	
	public List<FlightDetails> searchFlight(FlightSearchRequest searchCritirea) ;

}
