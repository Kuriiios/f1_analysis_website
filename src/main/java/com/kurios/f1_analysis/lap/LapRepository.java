package com.kurios.f1_analysis.lap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LapRepository extends JpaRepository<Lap, Integer> {

    List<Lap> findAllByDta_Id(Integer dtaId);

    @Query(value =
            "SELECT " +
                "lap.lap_start_date, " +
                "driver.driver_number, " +
                "driver.driver_hex_color, " +
                "driver.driver_abbreviation, " +
                "lap.sector1_time, " +
                "lap.speed_i1, " +
                "lap.sector2_time, " +
                "lap.speed_i2, " +
                "lap.sector3_time, " +
                "lap.speed_fl, " +
                "lap.laptime_ms, " +
                "lap.speed_st, " +
                "lap.lap_number, " +
                "compound.compound_name, " +
                "lap.stint "+
            "FROM lap " +
                "INNER JOIN compound ON lap.compound_id = compound.compound_id " +
                "INNER JOIN dta ON lap.dta_id = dta.dta_id " +
                "INNER JOIN event_session ON dta.event_session_id = event_session.event_session_id " +
                "INNER JOIN session_name ON event_session.session_name_id = session_name.session_name_id " +
                "INNER JOIN event_round ON event_session.event_round_id = event_round.event_round_id " +
                "INNER JOIN driver ON dta.driver_id = driver.driver_id " +
                "INNER JOIN team ON dta.team_id = team.team_id " +
            "WHERE " +
                "event_round.year = :year "+
                "AND event_round.round_number = :roundNumber "+
                "AND session_name.session_name_id = :sessionNameId "+
                "AND lap.lap_number = :lapNumber " +
            "ORDER BY lap_start_time;",
            nativeQuery = true
    )
    List<LapAllDriverDataDto> findAllDriverLapInfo(Integer year, Integer roundNumber, Integer sessionNameId, Short lapNumber);

    @Query(value =
            "SELECT " +
                "lap_start_date, " +
                "driver_number, " +
                "lap_number, " +
                "sector1_time, " +
                "speed_i1, " +
                "sector2_time, " +
                "speed_i2, " +
                "sector3_time, " +
                "speed_fl, " +
                "laptime_ms, " +
                "speed_st "+
            "FROM lap " +
                "INNER JOIN compound ON lap.compound_id = compound.compound_id " +
                "INNER JOIN dta ON lap.dta_id = dta.dta_id " +
                "INNER JOIN event_session ON dta.event_session_id = event_session.event_session_id " +
                "INNER JOIN session_name ON event_session.session_name_id = session_name.session_name_id " +
                "INNER JOIN event_round ON event_session.event_round_id = event_round.event_round_id " +
                "INNER JOIN driver ON dta.driver_id = driver.driver_id " +
                "INNER JOIN team ON dta.team_id = team.team_id " +
            "WHERE " +
                "event_round.year = :year "+
                "AND event_round.round_number = :roundNumber "+
                "AND event_session.session_name_id = :sessionNameId "+
                "AND lap.lap_number > :lapNumber-10 "+
                "AND lap.lap_number <= :lapNumber "+
                "AND driver.driver_number = :driverNumber "+
            "ORDER BY lap_start_date ",
            nativeQuery = true
    )
    List<LapDriverDataLastTenDto> findLastTenLapPerDriver(Integer year, Integer roundNumber, Integer sessionNameId, Short lapNumber, Short driverNumber);

    @Query(value =
            "SELECT " +
                "lap_start_date, " +
                "driver_abbreviation, " +
                "driver_hex_color, " +
                "driver_number, " +
                "lap_number, " +
                "CAST(sector_time_s AS DOUBLE PRECISION) as sector_time_s, " +
                "CAST(gap_s AS DOUBLE PRECISION) as gap_s, " +
                "CAST(ROUND((gap_s / min_sector_time_s), 3) AS DOUBLE PRECISION) as gap_percentage, " +
                "compound_name "+
            "FROM ( " +
                "SELECT " +
                    "lap_start_date, " +
                    "driver_abbreviation, " +
                    "driver_hex_color, " +
                    "driver_number, " +
                    "lap_number, " +
                    "compound_name, " +
                    "CASE " +
                        "WHEN :sectorNumber = 1 THEN ROUND(sector1_time / 1000.0, 3) " +
                        "WHEN :sectorNumber = 2 THEN ROUND(sector2_time / 1000.0, 3) " +
                        "WHEN :sectorNumber = 3 THEN ROUND(sector3_time / 1000.0, 3) " +
                        "ELSE 0.0 " +
                    "END AS sector_time_s, " +
                    "CASE " +
                        "WHEN :sectorNumber = 1 THEN MIN(sector1_time) OVER () / 1000.0 " +
                        "WHEN :sectorNumber = 2 THEN MIN(sector2_time) OVER () / 1000.0 " +
                        "WHEN :sectorNumber = 3 THEN MIN(sector3_time) OVER () / 1000.0 " +
                        "ELSE 0.0 " +
                    "END AS min_sector_time_s, " +
                    "CASE " +
                        "WHEN :sectorNumber = 1 THEN ROUND((sector1_time - MIN(sector1_time) OVER ()) / 1000.0, 3) " +
                        "WHEN :sectorNumber = 2 THEN ROUND((sector2_time - MIN(sector2_time) OVER ()) / 1000.0, 3) " +
                        "WHEN :sectorNumber = 3 THEN ROUND((sector3_time - MIN(sector3_time) OVER ()) / 1000.0, 3) " +
                        "ELSE 999.0 " +
                    "END AS gap_s, " +
                    "CASE " +
                        "WHEN :sectorNumber = 1 THEN ROW_NUMBER() OVER (PARTITION BY driver_abbreviation ORDER BY sector1_time ASC) " +
                        "WHEN :sectorNumber = 2 THEN ROW_NUMBER() OVER (PARTITION BY driver_abbreviation ORDER BY sector2_time ASC) " +
                        "WHEN :sectorNumber = 3 THEN ROW_NUMBER() OVER (PARTITION BY driver_abbreviation ORDER BY sector3_time ASC) " +
                        "ELSE 999 " +
                    "END AS rn " +
                "FROM lap " +
                    "INNER JOIN compound ON lap.compound_id = compound.compound_id " +
                    "INNER JOIN dta ON lap.dta_id = dta.dta_id " +
                    "INNER JOIN event_session ON dta.event_session_id = event_session.event_session_id " +
                    "INNER JOIN session_name ON event_session.session_name_id = session_name.session_name_id " +
                    "INNER JOIN event_round ON event_session.event_round_id = event_round.event_round_id " +
                    "INNER JOIN driver ON dta.driver_id = driver.driver_id " +
                    "INNER JOIN team ON dta.team_id = team.team_id " +
                "WHERE " +
                    "event_round.year = :year "+
                    "AND event_round.round_number = :roundNumber "+
                    "AND lap.lap_number <= :lapNumber "+
                    "AND ( " +
                        "(:sectorNumber = 1 AND sector1_time <> 0) OR " +
                        "(:sectorNumber = 2 AND sector2_time <> 0) OR " +
                        "(:sectorNumber = 3 AND sector3_time <> 0) " +
                    ") " +
                "GROUP BY " +
                    "driver_number, " +
                    "driver_abbreviation, " +
                    "driver_hex_color, " +
                    "compound_name, " +
                    "lap_start_date, " +
                    "lap_number, " +
                    "sector1_time, " +
                    "sector2_time, " +
                    "sector3_time " +
            ") AS subquery " +
            "WHERE rn = 1 " +
            "ORDER BY " +
                "gap_s;",
            nativeQuery = true
    )
    List<LapDriverDataSectorDto> findFastestSector(Integer year, Integer roundNumber, Integer sessionNameId, Short lapNumber, Short sectorNumber);
}
