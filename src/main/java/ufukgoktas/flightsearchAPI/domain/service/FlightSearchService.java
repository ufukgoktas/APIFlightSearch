package ufukgoktas.flightsearchAPI.domain.service;

import org.springframework.stereotype.Service;
import ufukgoktas.flightsearchAPI.rest.convertor.FlightToSearchResponseConvertor;
import ufukgoktas.flightsearchAPI.domain.entity.Flight;
import ufukgoktas.flightsearchAPI.exception.BusinessException;
import ufukgoktas.flightsearchAPI.rest.message.response.FlightSearchResponse;
import ufukgoktas.flightsearchAPI.rest.message.request.FlightSearchRequest;
import ufukgoktas.flightsearchAPI.domain.repository.FlightRepository;

import java.util.List;

@Service
public class FlightSearchService {
    private final FlightRepository flightRepository;
    private final FlightToSearchResponseConvertor flightToSearchResponseConvertor;

    public FlightSearchService(FlightRepository flightRepository, FlightToSearchResponseConvertor flightToSearchResponseConvertor) {
        this.flightRepository = flightRepository;
        this.flightToSearchResponseConvertor = flightToSearchResponseConvertor;
    }

    public List<FlightSearchResponse> searchFlights(FlightSearchRequest request) {
        List<Flight> flights = flightRepository.findByDepartureAirport_IdAndAndArrivalAirport_IdAndDepartureDateAndReturnDate(request.getDepartureAirportId(), request.getArrivalAirportId(), request.getDepartureDate(), request.getReturnDate());

        if (flights.isEmpty()) {
            throw new BusinessException("No flights found for the given criteria.");
        }

        return flightToSearchResponseConvertor.convert(flights);
    }

}
