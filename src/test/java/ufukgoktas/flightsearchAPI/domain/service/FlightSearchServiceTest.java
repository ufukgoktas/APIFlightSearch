package ufukgoktas.flightsearchAPI.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ufukgoktas.flightsearchAPI.exception.BusinessException;
import ufukgoktas.flightsearchAPI.rest.convertor.FlightToSearchResponseConvertor;
import ufukgoktas.flightsearchAPI.domain.entity.Flight;
import ufukgoktas.flightsearchAPI.rest.message.request.FlightSearchRequest;
import ufukgoktas.flightsearchAPI.rest.message.response.FlightSearchResponse;
import ufukgoktas.flightsearchAPI.domain.repository.FlightRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FlightSearchServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private FlightToSearchResponseConvertor flightToSearchResponseConvertor;

    private FlightSearchService flightSearchService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        flightSearchService = new FlightSearchService(flightRepository, flightToSearchResponseConvertor);
    }

    @Test
    public void testSearchFlights_FlightsFound() {
        FlightSearchRequest request = new FlightSearchRequest();
        request.setDepartureAirportId(1);
        request.setArrivalAirportId(2);
        request.setDepartureDate(LocalDate.now());

        List<Flight> mockFlights = new ArrayList<>();
        mockFlights.add(new Flight());

        when(flightRepository.findByDepartureAirport_IdAndAndArrivalAirport_IdAndDepartureDateAndReturnDate(
                request.getDepartureAirportId(),
                request.getArrivalAirportId(),
                request.getDepartureDate(),
                request.getReturnDate()))
                .thenReturn(mockFlights);

        List<FlightSearchResponse> expectedResponses = new ArrayList<>();
        when(flightToSearchResponseConvertor.convert(mockFlights)).thenReturn(expectedResponses);

        List<FlightSearchResponse> actualResponses = flightSearchService.searchFlights(request);

        assertEquals(expectedResponses, actualResponses);
    }

    @Test
    public void testSearchFlights_NoFlightsFound() {
        FlightSearchRequest request = new FlightSearchRequest();
        // Set up request parameters

        when(flightRepository.findByDepartureAirport_IdAndAndArrivalAirport_IdAndDepartureDateAndReturnDate(
                request.getDepartureAirportId(),
                request.getArrivalAirportId(),
                request.getDepartureDate(),
                request.getReturnDate()))
                .thenReturn(new ArrayList<>());

        assertThrows(BusinessException.class, () -> flightSearchService.searchFlights(request));
    }
}
