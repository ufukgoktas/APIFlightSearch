package ufukgoktas.flightsearchAPI.rest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufukgoktas.flightsearchAPI.rest.message.response.FlightSearchResponse;
import ufukgoktas.flightsearchAPI.rest.message.request.FlightSearchRequest;
import ufukgoktas.flightsearchAPI.domain.service.FlightSearchService;

import java.util.List;

@RestController
@RequestMapping("api/v1/flight/search")
public class FlightSearchController {

    private final FlightSearchService flightSearchService;

    public FlightSearchController(FlightSearchService flightSearchService) {
        this.flightSearchService = flightSearchService;
    }

    @GetMapping
    public List<FlightSearchResponse> searchFlight(@RequestBody FlightSearchRequest request) {
        return flightSearchService.searchFlights(request);
    }
}
