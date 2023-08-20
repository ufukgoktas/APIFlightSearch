package ufukgoktas.flightsearchAPI.domain.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ufukgoktas.flightsearchAPI.domain.entity.Airport;
import ufukgoktas.flightsearchAPI.domain.repository.AirportRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class AirportServiceTest {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private AirportService airportService;

    @Test
    void testGetAirportById() {
        // Arrange
        Integer airportId = 1;
        Airport expectedAirport = new Airport();
        expectedAirport.setId(airportId);

        when(airportRepository.findById(airportId)).thenReturn(Optional.of(expectedAirport));

        // Act
        Airport resultAirport = airportService.getAirportById(airportId);

        // Assert
        assertNotNull(resultAirport);
        assertEquals(expectedAirport.getId(), resultAirport.getId());
    }

    @Test
    void testGetAirportByIdNotFound() {
        // Arrange
        Integer airportId = 1;

        when(airportRepository.findById(airportId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalAccessError.class, () -> airportService.getAirportById(airportId));
    }
}
