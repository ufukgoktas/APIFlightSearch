package ufukgoktas.flightsearchAPI.domain.service;
import org.springframework.stereotype.Service;
import ufukgoktas.flightsearchAPI.domain.entity.Flight;
import ufukgoktas.flightsearchAPI.rest.message.request.FlightCreateRequest;
import ufukgoktas.flightsearchAPI.domain.repository.FlightRepository;

@Service
public class FlightCreateService {
    private final FlightRepository flightRepository;
    private final AirportService airportService;

    public FlightCreateService(FlightRepository flightRepository, AirportService airportService) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
    }

    public void create(FlightCreateRequest request) {
        Flight flight = new Flight();

        flight.setArrivalAirport(airportService.getAirportById(request.getArrivalAirportId()));
        flight.setDepartureAirport(airportService.getAirportById(request.getDepartureAirportId()));
        flight.setDepartureDate(request.getDepartureDate());
        flight.setReturnDate(request.getReturnDate());
        flight.setPrice(request.getPrice());

        flightRepository.save(flight);
    }

}
