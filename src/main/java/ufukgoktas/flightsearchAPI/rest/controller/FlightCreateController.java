package ufukgoktas.flightsearchAPI.rest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufukgoktas.flightsearchAPI.domain.validator.CreateFlightValidator;
import ufukgoktas.flightsearchAPI.rest.message.request.FlightCreateRequest;
import ufukgoktas.flightsearchAPI.domain.service.FlightCreateService;


@RestController
@RequestMapping("api/v1/flight")
public class FlightCreateController {
private final FlightCreateService flightCreateService;
private final CreateFlightValidator createFlightValidator;
    public FlightCreateController(FlightCreateService flightCreateService, CreateFlightValidator createFlightValidator) {
        this.flightCreateService = flightCreateService;
        this.createFlightValidator = createFlightValidator;
    }

    @PostMapping
    public void createFlight(@RequestBody FlightCreateRequest request) {
        createFlightValidator.validate(request);
        flightCreateService.create(request);
    }
}
