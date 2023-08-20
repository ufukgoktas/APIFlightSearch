package ufukgoktas.flightsearchAPI.rest.controller.mock;

import java.util.List;

public class MockFlightsResponse {

   private List<MockFlightDto> flight;

    public List<MockFlightDto> getFlight() {
        return flight;
    }

    public void setFlight(List<MockFlightDto> flight) {
        this.flight = flight;
    }
}
