package ufukgoktas.flightsearchAPI.domain.service;

import org.springframework.stereotype.Service;
import ufukgoktas.flightsearchAPI.domain.entity.Flight;
import ufukgoktas.flightsearchAPI.domain.repository.FlightRepository;
import ufukgoktas.flightsearchAPI.exception.BusinessException;
import ufukgoktas.flightsearchAPI.rest.message.request.FlightUpdateRequest;

import java.util.Optional;

@Service
public class FlightUpdateService {

    private final FlightRepository flightRepository;
    private final AirportService airportService;

    public FlightUpdateService(FlightRepository flightRepository, AirportService airportService) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
    }

    public void update(FlightUpdateRequest request) {
        Optional<Flight> flightOptional = flightRepository.findById(request.getFlightId());

        if (flightOptional.isEmpty()) {
            throw new BusinessException("Flight not found ");
        }

        Flight flight = flightOptional.get();

        flight.setArrivalAirport(airportService.getAirportById(request.getArrivalAirportId()));
        flight.setDepartureAirport(airportService.getAirportById(request.getDepartureAirportId()));
        flight.setDepartureDate(request.getDepartureDate());
        flight.setReturnDate(request.getReturnDate());
        flight.setPrice(request.getPrice());

        flightRepository.save(flight);
    }
}


