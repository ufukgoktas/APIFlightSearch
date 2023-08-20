package ufukgoktas.flightsearchAPI.domain.entity;

import javax.persistence.*;


@Entity(name = "airport")
@SequenceGenerator(name = "id_generator", sequenceName = "seq_airport", allocationSize = 1)
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "city", nullable = false)
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
