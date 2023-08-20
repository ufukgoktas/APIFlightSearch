package ufukgoktas.flightsearchAPI.domain.service;

import org.springframework.stereotype.Service;
import ufukgoktas.flightsearchAPI.domain.entity.Airport;

import ufukgoktas.flightsearchAPI.domain.repository.AirportRepository;
@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport getAirportById(Integer airportId) {
        return airportRepository.findById(airportId).orElseThrow(IllegalAccessError::new);//todo:not found
    }
}
