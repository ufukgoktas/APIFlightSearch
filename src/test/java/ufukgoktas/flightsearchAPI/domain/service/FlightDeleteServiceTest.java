package ufukgoktas.flightsearchAPI.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ufukgoktas.flightsearchAPI.domain.repository.FlightRepository;

import static org.mockito.Mockito.*;

public class FlightDeleteServiceTest {

    @Mock
    private FlightRepository flightRepository;

    private FlightDeleteService flightDeleteService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        flightDeleteService = new FlightDeleteService(flightRepository);
    }

    @Test
    public void testDeleteFlight() {
        Integer flightIdToDelete = 123;

        flightDeleteService.delete(flightIdToDelete);

        verify(flightRepository, times(1)).deleteById(flightIdToDelete);
    }
}
