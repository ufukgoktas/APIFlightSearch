package ufukgoktas.flightsearchAPI.domain.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ufukgoktas.flightsearchAPI.domain.service.AirportService;
import ufukgoktas.flightsearchAPI.domain.repository.FlightRepository;
import ufukgoktas.flightsearchAPI.exception.BusinessException;
import ufukgoktas.flightsearchAPI.rest.message.request.FlightCreateRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class CreateFlightValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateFlightValidator.class);
    private final FlightRepository flightRepository;
    private final AirportService airportService;

    public CreateFlightValidator(FlightRepository flightRepository, AirportService airportService) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
    }

    public void validate(FlightCreateRequest request) {

        if (request.getArrivalAirportId() == null) {
            throw new BusinessException("ArrivalAirport boş olamazz");
        }
        if (request.getDepartureAirportId() == null) {
            throw new BusinessException("DepartureAirportId boş olamaz");
        }

        if (request.getDepartureDate() == null) {
            throw new BusinessException("DepartureDate boş olamaz");
        }

        if (request.getReturnDate() != null && request.getReturnDate().isBefore(LocalDateTime.now())) {
            throw new BusinessException("ReturnDate geçerli bir tarih olmalı");
        }

        if (request.getPrice() < 0) {
            throw new BusinessException("Price negatif olamaz");

        }
    }

}
