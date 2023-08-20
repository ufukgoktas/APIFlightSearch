package ufukgoktas.flightsearchAPI.domain.validator;

import org.springframework.stereotype.Service;
import ufukgoktas.flightsearchAPI.domain.service.AirportService;
import ufukgoktas.flightsearchAPI.exception.BusinessException;
import ufukgoktas.flightsearchAPI.rest.message.request.FlightUpdateRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UpdateFlightValidator {
    private AirportService airportService;

    public UpdateFlightValidator(AirportService airportService) {
        this.airportService = airportService;
    }

    public void validate(FlightUpdateRequest request) {

        if (request.getFlightId() == null) {
            throw new BusinessException("FlightId boş olamaz");
        }

        if (request.getDepartureAirportId() == null) {
            throw new BusinessException("DepartureAirportId boş olamaz");
        }

        if (request.getArrivalAirportId() == null) {
            throw new BusinessException("ArrivalAirportId boş olamaz");
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
