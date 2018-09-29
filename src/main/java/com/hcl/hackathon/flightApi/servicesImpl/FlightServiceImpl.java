package com.hcl.hackathon.flightApi.servicesImpl;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.resources.FlightDestination;
import com.hcl.hackathon.flightApi.model.FlightInfo;
import com.hcl.hackathon.flightApi.services.FlightService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Value("${amadeus.clientId}")
    String clientId;

    @Value("${amadeus.clientSecret}")
    String clientSecret;

    @Override
    public List<FlightInfo> getAllFlightDetails(String origin, String departureDate) throws Exception{


        Amadeus amadeus = Amadeus
                .builder(clientId, clientSecret)
                .build();

        FlightDestination[] flightDestinations =amadeus.shopping.flightDestinations.get(Params
                .with("origin", origin)
                .and("departureDate",departureDate)
                .and("nonStop","true")
        );

        List<FlightInfo> flightInfo = new ArrayList<FlightInfo>();

        for (FlightDestination destination: flightDestinations) {


            FlightInfo flightInfo1 =  FlightInfo.builder()
                    .sourceLocation(destination.getOrigin())
                    .destinationLocation(destination.getDestination())
                    .price(destination.getPrice().getTotal())
                    .build();

            flightInfo.add(flightInfo1);

        }

        //Get All Flight Details
        /*FlightOffer[] test = amadeus.shopping.flightOffers.get(Params
            .with("origin", "LHR")
            .and("destination","LAX")
            .and("departureDate","2018-12-24")
        );

        //Get ALl Locations of Flight
        Location[] locations = amadeus.referenceData.locations.get(Params
                .with("keyword", "LON")
                .and("subType", Locations.ANY));
        */
        return flightInfo;
    }
}
