package ufukgoktas.flightsearchAPI.rest.controller;


import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufukgoktas.flightsearchAPI.domain.validator.UpdateFlightValidator;
import ufukgoktas.flightsearchAPI.rest.message.request.FlightUpdateRequest;
import ufukgoktas.flightsearchAPI.domain.service.FlightUpdateService;

@RestController
@RequestMapping("api/v1/flight")
public class FlightUpdateController {
private final  FlightUpdateService flightUpdateService;
private final UpdateFlightValidator updateFlightValidator;
    public FlightUpdateController(FlightUpdateService flightUpdateService, UpdateFlightValidator updateFlightValidator) {
        this.flightUpdateService = flightUpdateService;
        this.updateFlightValidator = updateFlightValidator;
    }

    @PutMapping
    public void updateFlight(@RequestBody FlightUpdateRequest request) {
        updateFlightValidator.validate(request);
        flightUpdateService.update(request);
    }
}
