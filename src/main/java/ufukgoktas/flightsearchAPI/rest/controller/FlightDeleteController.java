package ufukgoktas.flightsearchAPI.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufukgoktas.flightsearchAPI.domain.service.FlightDeleteService;

@RestController
@RequestMapping("api/v1/flight")
public class FlightDeleteController {
private final FlightDeleteService flightDeleteService;

    public FlightDeleteController(FlightDeleteService flightDeleteService) {
        this.flightDeleteService = flightDeleteService;
    }

    @DeleteMapping("/{flightId}")
    public void deleteFlight(@PathVariable Integer flightId) {
        flightDeleteService.delete(flightId);
    }
}
