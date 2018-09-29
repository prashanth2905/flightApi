package com.hcl.hackathon.flightApi.services;

import com.hcl.hackathon.flightApi.model.FlightInfo;

import java.util.List;

public interface FlightService {

    List<FlightInfo> getAllFlightDetails(String origin, String departureDate) throws Exception;


}
