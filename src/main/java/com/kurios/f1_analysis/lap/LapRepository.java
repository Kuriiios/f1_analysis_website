package com.kurios.f1_analysis.lap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LapRepository extends JpaRepository<Lap, Integer> {

    List<Lap> findAllByDta_Id(Integer dtaId);

    @Query(value = "SELECT " +
            //"lap_start_date, driver_number, driver_hex_color, driver_abbreviation, sector1_time, speed_i1, sector2_time, speed_i2, sector3_time, speed_fl, laptime_ms, speed_st, lap_number, compound_name, stint "+
            "lap.* " +
            "FROM lap " +
            "INNER JOIN compound ON lap.compound_id = compound.compound_id " +
            "INNER JOIN dta ON lap.dta_id = dta.dta_id " +
            "INNER JOIN event_session ON dta.event_session_id = event_session.event_session_id " +
            "INNER JOIN session_name ON event_session.session_name_id = session_name.session_name_id " +
            "INNER JOIN event_round ON event_session.event_round_id = event_round.event_round_id " +
            "INNER JOIN driver ON dta.driver_id = driver.driver_id " +
            "INNER JOIN team ON dta.team_id = team.team_id " +
            "WHERE event_round.year = :year "+
            "AND event_round.round_number = :roundNumber "+
            "AND session_name.session_name_id = :sessionNameId "+
            "AND lap.lap_number = :lapNumber " +
            "ORDER BY lap_start_time;",
            nativeQuery = true
    )
    List<Lap> findLapDataByYearRoundNumberSessionLapNumber(Integer year, Integer roundNumber, Integer sessionNameId, Integer lapNumber);

    @Query(value = "SELECT " +
            "lap_start_date, driver_number, lap_number, sector1_time, speed_i1, sector2_time, speed_i2, sector3_time, speed_fl, laptime_ms, speed_st "+
            "FROM lap " +
            "INNER JOIN compound ON lap.compound_id = compound.compound_id " +
            "INNER JOIN dta ON lap.dta_id = dta.dta_id " +
            "INNER JOIN event_session ON dta.event_session_id = event_session.event_session_id " +
            "INNER JOIN session_name ON event_session.session_name_id = session_name.session_name_id " +
            "INNER JOIN event_round ON event_session.event_round_id = event_round.event_round_id " +
            "INNER JOIN driver ON dta.driver_id = driver.driver_id " +
            "INNER JOIN team ON dta.team_id = team.team_id " +
            "WHERE event_round.year = :year "+
            "AND event_round.round_number = :roundNumber "+
            "AND event_session.session_name_id = :sessionNameId "+
            "AND lap.lap_number > :lapNumber-10 "+
            "AND lap.lap_number <= :lapNumber "+
            "AND driver.driver_number = :driverNumber "+
            "ORDER BY lap_start_date ",
            nativeQuery = true
    )
    List<Lap> findLastTenLapPerDriver(Integer year, Integer roundNumber, Integer sessionNameId, Integer lapNumber, Integer driverNumber);

    @Query(value = "SELECT " +
            "lap_start_date, driver_abbreviation, driver_hex_color, driver_number, lap_number, sector1_time_s, gap_s, gap_percentage, compound_name "+
            "FROM ( " +
            "SELECT " +
            "lap_start_date, driver_abbreviation, driver_hex_color, driver_number, lap_number, sector1_time_s, gap_s, gap_percentage, compound_name" +
            "(sector1_time - MIN(sector1_time) OVER ()) AS gap_ms, " +
            "ROUND(sector1_time / 1000.0, 3) AS sector1_time_s, " +
            "ROUND((sector1_time - MIN(sector1_time) OVER ()) / 1000.0, 3) AS gap_s, " +
            "ROW_NUMBER() OVER (PARTITION BY driver_abbreviation ORDER BY sector1_time ASC) as rn " +
            "FROM lap " +
            "INNER JOIN compound ON lap.compound_id = compound.compound_id " +
            "INNER JOIN dta ON lap.dta_id = dta.dta_id " +
            "INNER JOIN event_session ON dta.event_session_id = event_session.event_session_id " +
            "INNER JOIN session_name ON event_session.session_name_id = session_name.session_name_id " +
            "INNER JOIN event_round ON event_session.event_round_id = event_round.event_round_id " +
            "INNER JOIN driver ON dta.driver_id = driver.driver_id " +
            "INNER JOIN team ON dta.team_id = team.team_id " +
            "WHERE event_round.year = :year "+
            "AND event_round.round_number = :roundNumber "+
            "AND event_session.session_name_id = :sessionNameId "+
            "AND sector1_time <> 0" +
            "GROUP BY " +
            "driver_number, driver_abbreviation, driver_hex_color, compound_name, lap_start_date, lap_number, sector1_time " +
            "ORDER BY sector1_time ASC " +
            ") AS subquery " +
            "WHERE rn = 1;"
            ,
            nativeQuery = true
    )
    List<Lap> findFastestPerSubSession(Integer year, Integer roundNumber, Integer sessionNameId, Integer lapNumber, Integer driverNumber);
}
