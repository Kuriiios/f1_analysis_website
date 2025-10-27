package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.lap.Lap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    @Query(value = "SELECT " +
            "weather.time, air_temp, humidity, pressure, is_rainfall, track_temp, wind_speed, wind_direction " +
            "FROM weather " +
            "WHERE event_round.year = :year "+
            "AND event_round.round_number = :roundNumber "+
            "AND event_session.session_name_id = :sessionNameId "+
            "ORDER BY weather.time;",
            nativeQuery = true
    )
    List<Lap> findAllWeatherDataPerSession(Integer year, Integer roundNumber, Integer sessionNameId);
}
