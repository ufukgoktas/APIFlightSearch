package ufukgoktas.flightsearchAPI.domain.service;

import org.springframework.stereotype.Service;
import ufukgoktas.flightsearchAPI.domain.repository.FlightRepository;
@Service
public class FlightDeleteService {
private final FlightRepository flightRepository;

    public FlightDeleteService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void delete(Integer flightId) {
        flightRepository.deleteById(flightId);
    }
}
