package com.simple.flightSearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.flightSearch.dto.FlightSearchRequest;
import com.simple.flightSearch.model.FlightDetails;
import com.simple.flightSearch.service.FlightSearchService;

@RestController
public class FlightSearchController {
	
	@Autowired
	private FlightSearchService searchService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/search")
	public ResponseEntity<List<FlightDetails>> search(@RequestBody FlightSearchRequest req) {
		List<FlightDetails> flightLists = searchService.searchFlight(req);
		return new ResponseEntity<>(flightLists, HttpStatus.OK);
	}
}
