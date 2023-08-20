package ufukgoktas.flightsearchAPI.rest.convertor;

import org.springframework.stereotype.Service;
import ufukgoktas.flightsearchAPI.domain.entity.Flight;
import ufukgoktas.flightsearchAPI.rest.message.response.FlightSearchResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightToSearchResponseConvertor {

    public List<FlightSearchResponse> convert(List<Flight> flights) {
        return flights
                .stream()
                .map(flight -> {
                            FlightSearchResponse flightSearchResponse = new FlightSearchResponse();
                            flightSearchResponse.setPrice(flight.getPrice());
                            flightSearchResponse.setDepartureAirport(flight.getDepartureAirport().getCity());
                            flightSearchResponse.setArrivalAirport(flight.getArrivalAirport().getCity());
                            flightSearchResponse.setReturnDate(flight.getReturnDate());
                            flightSearchResponse.setDepartureDate(flight.getDepartureDate());
                            return flightSearchResponse;
                        }
                )
                .collect(Collectors.toList());
    }
}
