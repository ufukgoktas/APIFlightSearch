package ufukgoktas.flightsearchAPI.domain.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ufukgoktas.flightsearchAPI.domain.entity.Airport;
import ufukgoktas.flightsearchAPI.domain.entity.Flight;
import ufukgoktas.flightsearchAPI.domain.repository.FlightRepository;
import ufukgoktas.flightsearchAPI.rest.message.request.FlightCreateRequest;

import java.time.LocalDateTime;
import java.util.Date;

import static org.mockito.Mockito.*;

@SpringBootTest
class FlightCreateServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private AirportService airportService;

    @InjectMocks
    private FlightCreateService flightCreateService;

    @Test
    void testCreateFlight() {
        // Arrange
        FlightCreateRequest request = new FlightCreateRequest();
        request.setDepartureAirportId(1);
        request.setArrivalAirportId(2);
        request.setDepartureDate(LocalDateTime.now());
        request.setReturnDate(LocalDateTime.now());
        request.setPrice(200.0);

        Airport departureAirport = new Airport();
        departureAirport.setId(request.getDepartureAirportId());

        Airport arrivalAirport = new Airport();
        arrivalAirport.setId(request.getArrivalAirportId());

        when(airportService.getAirportById(request.getDepartureAirportId())).thenReturn(departureAirport);
        when(airportService.getAirportById(request.getArrivalAirportId())).thenReturn(arrivalAirport);

        // Act
        flightCreateService.create(request);

        // Assert
        verify(flightRepository, times(1)).save(any(Flight.class));
    }
}
