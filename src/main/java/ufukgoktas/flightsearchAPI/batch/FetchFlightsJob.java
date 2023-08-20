package ufukgoktas.flightsearchAPI.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ufukgoktas.flightsearchAPI.rest.controller.mock.MockFlightsResponse;
import ufukgoktas.flightsearchAPI.rest.message.request.FlightCreateRequest;
import ufukgoktas.flightsearchAPI.domain.service.FlightCreateService;

@Component
public class FetchFlightsJob {

    private final RestTemplate restTemplate;
    private final FlightCreateService flightCreateService;

    public FetchFlightsJob(RestTemplate restTemplate, FlightCreateService flightCreateService) {
        this.restTemplate = restTemplate;
        this.flightCreateService = flightCreateService;
    }

    @Scheduled(cron = "0 0 4 * * *")
    public void fetchFlights() {
        String mockApiUrl = "http://localhost:8080/api/mock/flight"; // Mock API'nin URL'si
        MockFlightsResponse response = restTemplate.getForObject(mockApiUrl, MockFlightsResponse.class);
        response.getFlight().forEach(mockFlightDto -> {
            FlightCreateRequest request = new FlightCreateRequest();
            request.setArrivalAirportId(mockFlightDto.getArrivalAirportId());
            request.setDepartureAirportId(mockFlightDto.getArrivalAirportId());
            request.setDepartureDate(mockFlightDto.getDepartureDate());
            request.setReturnDate(mockFlightDto.getReturnDate());
            flightCreateService.create(request);
        });
    }
}
