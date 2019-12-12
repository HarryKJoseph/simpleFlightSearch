package com.simple.flightSearch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.simple.flightSearch.dto.FlightSearchRequest;
import com.simple.flightSearch.jsonReader.JsonReader;
import com.simple.flightSearch.model.FlightDetails;

@Service
public class FlightSearchImpl implements FlightSearchService {
	
	@Autowired
	private JsonReader jsonReader;
	List<FlightDetails> details;
	
	//Search the json file and get matching Flight number and Date or Origin and destn and date 
	@Override
	public List<FlightDetails> searchFlight(FlightSearchRequest searchReq) {

		List<FlightDetails> searchResult = new ArrayList<FlightDetails>();
		details = jsonReader.getFlightDtlFromFile();
		if (!StringUtils.isEmpty(searchReq.getFlightNumber())) {
			searchResult = details.stream()
					.filter(dates -> searchReq.getFlightNumber().equals(dates.getFlightNumber())
							&& searchReq.getDate().equals(dates.getDeparture().toLocalDate()))
					.collect(Collectors.toList());
		} else if(!StringUtils.isEmpty(searchReq.getOrigin()) && !StringUtils.isEmpty(searchReq.getDestination())) {
			searchResult = details.stream()
					.filter(dates -> searchReq.getOrigin().equalsIgnoreCase(dates.getOrigin())
							&& searchReq.getDestination().equalsIgnoreCase(dates.getDestination())
							&& searchReq.getDate().equals(dates.getDeparture().toLocalDate()))
					.collect(Collectors.toList());
		}

		return searchResult;
	}

}
