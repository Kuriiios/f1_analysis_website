package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.lap.Lap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    @Query(value =
            "SELECT " +
                "TO_CHAR(INTERVAL '1 second' * w.time, 'HH24:MI:SS') AS time, " +
                "w.air_temp, " +
                "w.humidity, " +
                "w.pressure, " +
                "w.is_rainfall, " +
                "w.track_temp, " +
                "w.wind_speed, " +
                "w.wind_direction " +
            "FROM weather AS w " +
                "INNER JOIN event_session AS es ON w.event_session_id = es.event_session_id " +
                "INNER JOIN session_name AS sn ON es.session_name_id = sn.session_name_id " +
                "INNER JOIN event_round AS er ON es.event_round_id = er.event_round_id " +
            "WHERE er.year = :year "+
                "AND er.round_number = :roundNumber "+
                "AND es.session_name_id = :sessionNameId "+
            "ORDER BY w.time;",
            nativeQuery = true
    )
    List<WeatherDataDto> findWeatherDataPerSession(Integer year, Integer roundNumber, Integer sessionNameId);
}
