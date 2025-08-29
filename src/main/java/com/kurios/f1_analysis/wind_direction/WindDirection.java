package com.kurios.f1_analysis.wind_direction;

import com.kurios.f1_analysis.weather.Weather;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class WindDirection {
    @Id
    @Column(name = "wind_direction_id")
    private Integer id;

    @OneToMany(
            mappedBy = "windDirection",
            cascade = CascadeType.ALL
    )
    private List<Weather> weatherList;

    @Column(length = 3,
            unique = true,
            nullable = false)
    private String cardinalDirection;

    public WindDirection() {
    }

    public WindDirection(Integer id, String cardinalDirection) {
        this.id = id;
        this.cardinalDirection = cardinalDirection;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardinalDirection() {
        return cardinalDirection;
    }

    public void setCardinalDirection(String cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }
}
