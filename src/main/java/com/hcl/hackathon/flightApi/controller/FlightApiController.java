package com.hcl.hackathon.flightApi.controller;

import com.hcl.hackathon.flightApi.model.FlightInfo;
import com.hcl.hackathon.flightApi.services.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FlightApiController {

    @Autowired
    private FlightService flightService;

    @ApiOperation(
            value = "Get the current flight details")
    @GetMapping(value = "/api/flightApi", params = {"origin", "departureDate"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Flight Details", response = String.class),
            @ApiResponse(code = 404, message = "Details Not found", response = String.class)})
    public ResponseEntity<List<FlightInfo>> getAsyncSearch(@ApiParam("origin") String origin,
                                                     @ApiParam("departureDate") String departureDate) throws Exception {



        List<FlightInfo> allFlightDetails = flightService.getAllFlightDetails(origin, departureDate);

        return new ResponseEntity<List<FlightInfo>>(allFlightDetails, HttpStatus.OK);
    }
}
