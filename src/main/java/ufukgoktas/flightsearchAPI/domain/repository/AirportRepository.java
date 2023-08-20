package ufukgoktas.flightsearchAPI.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufukgoktas.flightsearchAPI.domain.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {

 //   boolean existsByCity(String city);
}
