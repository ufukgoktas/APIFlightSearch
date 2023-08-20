package ufukgoktas.flightsearchAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FlightSearchAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightSearchAPIApplication.class, args);
	}

}
