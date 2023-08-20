package ufukgoktas.flightsearchAPI.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ufukgoktas.flightsearchAPI.domain.entity.Airport;
import ufukgoktas.flightsearchAPI.domain.entity.Flight;
import ufukgoktas.flightsearchAPI.domain.repository.FlightRepository;
import ufukgoktas.flightsearchAPI.exception.BusinessException;
import ufukgoktas.flightsearchAPI.rest.message.request.FlightUpdateRequest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FlightUpdateServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private AirportService airportService;

    private FlightUpdateService flightUpdateService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        flightUpdateService = new FlightUpdateService(flightRepository, airportService);
    }

    @Test
    public void testUpdateFlight_Success() {
        FlightUpdateRequest request = new FlightUpdateRequest();
        // Set up request parameters

        Flight existingFlight = new Flight();
        when(flightRepository.findById(request.getFlightId())).thenReturn(Optional.of(existingFlight));

        Airport departureAirport = new Airport();
        Airport arrivalAirport = new Airport();
        when(airportService.getAirportById(request.getDepartureAirportId())).thenReturn(departureAirport);
        when(airportService.getAirportById(request.getArrivalAirportId())).thenReturn(arrivalAirport);

        flightUpdateService.update(request);

        assertEquals(departureAirport, existingFlight.getDepartureAirport());
        assertEquals(arrivalAirport, existingFlight.getArrivalAirport());
        assertEquals(request.getDepartureDate(), existingFlight.getDepartureDate());
        assertEquals(request.getReturnDate(), existingFlight.getReturnDate());
        assertEquals(request.getPrice(), existingFlight.getPrice());
        verify(flightRepository, times(1)).save(existingFlight);
    }

    @Test
    public void testUpdateFlight_FlightNotFound() {
        FlightUpdateRequest request = new FlightUpdateRequest();
        // Set up request parameters

        when(flightRepository.findById(request.getFlightId())).thenReturn(Optional.empty());

        assertThrows(BusinessException.class, () -> flightUpdateService.update(request));
    }
}
