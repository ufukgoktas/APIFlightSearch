package ufukgoktas.flightsearchAPI.rest.controller.mock;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/mock/flight")
public class MockFlightController {

    @GetMapping
    public MockFlightsResponse get() {
        MockFlightDto flight1 = new MockFlightDto();
        flight1.setDepartureAirport("Istanbul Airport");
        flight1.setArrivalAirport("Madrid Airport");
        flight1.setDepartureDate(LocalDateTime.now().plusDays(2));
        flight1.setReturnDate(LocalDateTime.now().plusDays(5));
        flight1.setPrice(987.86);

        MockFlightDto flight2 = new MockFlightDto();
        flight2.setDepartureAirport("London Heathrow");
        flight2.setArrivalAirport("New York JFK");
        flight2.setDepartureDate(LocalDateTime.now().plusDays(1));
        flight2.setReturnDate(LocalDateTime.now().plusDays(10));
        flight2.setPrice(1250.0);

        MockFlightDto flight3 = new MockFlightDto();
        flight3.setDepartureAirport("Paris Charles de Gaulle");
        flight3.setArrivalAirport("Tokyo Haneda");
        flight3.setDepartureDate(LocalDateTime.now().plusDays(7));
        flight3.setReturnDate(LocalDateTime.now().plusDays(14));
        flight3.setPrice(1899.99);

        MockFlightsResponse mockFlightsResponse = new MockFlightsResponse();
        mockFlightsResponse.setFlight(List.of(flight1, flight2, flight3));
        return mockFlightsResponse;
    }
}
