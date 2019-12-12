package com.simple.flightSearch.jsonReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.simple.flightSearch.model.FlightDetails;

@Component
public class JsonReader {
	
	@Value( "${json.config.folder}" )
	private String jsonFile;
	ObjectMapper objectMapper = new ObjectMapper();
	List<FlightDetails> details;

	//read json file and convert to Flight details object
	public List<FlightDetails> getFlightDtlFromFile(){
		
		File file;
		try {
			file = new ClassPathResource(jsonFile).getFile();
			objectMapper.registerModule(new JavaTimeModule());
			details = objectMapper.readValue(file, new TypeReference<List<FlightDetails>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return details;
		
	}
}
