package ufukgoktas.flightsearchAPI.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufukgoktas.flightsearchAPI.domain.entity.Flight;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByDepartureAirport_IdAndAndArrivalAirport_IdAndDepartureDateAndReturnDate(Integer departureAirportId, Integer arrivalAirportId, LocalDate departureDate, LocalDate returnDate);
boolean existsByDepartureAirport_IdAndAndArrivalAirport_IdAndDepartureDateAndReturnDate(Integer departureAirportId, Integer arrivalAirportId, LocalDate departureDate, LocalDate returnDate);
}
