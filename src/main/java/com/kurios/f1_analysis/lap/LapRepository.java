package com.kurios.f1_analysis.lap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LapRepository extends JpaRepository<Lap, Integer> {

    List<Lap> findAllByDta_Id(Integer dtaId);

    @Query(value =
            "SELECT " +
                "l.lap_start_date, " +
                "d.driver_number, " +
                "d.driver_hex_color, " +
                "d.driver_abbreviation, " +
                "CAST(ROUND(l.sector1_time / 1000.0, 3) AS DOUBLE PRECISION) AS sector1_time, " +
                "l.speed_i1, " +
                "CAST(ROUND(l.sector2_time / 1000.0, 3) AS DOUBLE PRECISION) AS sector2_time, " +
                "l.speed_i2, " +
                "CAST(ROUND(l.sector3_time / 1000.0, 3) AS DOUBLE PRECISION) AS sector3_time, " +
                "l.speed_fl, " +
                "CONCAT( " +
                    "FLOOR(l.laptime_ms / 60000), " +
                    "':' ," +
                "LPAD( " +
                    "CAST(FLOOR((l.laptime_ms % 60000) / 1000) AS TEXT), " +
                    "2, " +
                        "'0' " +
                        "), " +
                    "'.'," +
                "LPAD( " +
                    "CAST((l.laptime_ms % 1000) AS TEXT), " +
                    "3, " +
                        "'0' " +
                        ") " +
                ") AS formatted_laptime, " +
                "l.speed_st, " +
                "l.lap_number, " +
                "c.compound_name, " +
                "l.stint "+
            "FROM lap AS l " +
                "INNER JOIN compound AS c ON l.compound_id = c.compound_id " +
                "INNER JOIN dta ON l.dta_id = dta.dta_id " +
                "INNER JOIN event_session AS es ON dta.event_session_id = es.event_session_id " +
                "INNER JOIN session_name AS sn ON es.session_name_id = sn.session_name_id " +
                "INNER JOIN event_round AS er ON es.event_round_id = er.event_round_id " +
                "INNER JOIN driver AS d ON dta.driver_id = d.driver_id " +
            "WHERE " +
                "er.year = :year "+
                "AND er.round_number = :roundNumber "+
                "AND sn.session_name_id = :sessionNameId "+
                "AND l.lap_number = :lapNumber " +
            "ORDER BY lap_start_time;",
            nativeQuery = true
    )
    List<LapAllDriverDataDto> findAllDriverLapInfo(Integer year, Integer roundNumber, Integer sessionNameId, Short lapNumber);

    @Query(value =
            "SELECT " +
                "l.lap_start_date, " +
                "d.driver_number, " +
                "l.lap_number, " +
                "CAST(ROUND(l.sector1_time / 1000.0, 3) AS DOUBLE PRECISION) AS sector1_time, " +
                "l.speed_i1, " +
                "CAST(ROUND(l.sector2_time / 1000.0, 3) AS DOUBLE PRECISION) AS sector2_time, " +
                "l.speed_i2, " +
                "CAST(ROUND(l.sector3_time / 1000.0, 3) AS DOUBLE PRECISION) AS sector3_time, " +
                "l.speed_fl, " +
                "CONCAT( " +
                    "FLOOR(l.laptime_ms / 60000), " +
                        "':' ," +
                "LPAD( " +
                    "CAST(FLOOR((l.laptime_ms % 60000) / 1000) AS TEXT), " +
                    "2, " +
                        "'0' " +
                "), " +
                "'.'," +
                "LPAD( " +
                    "CAST((l.laptime_ms % 1000) AS TEXT), " +
                    "3, " +
                        "'0' " +
                        ") " +
                ") AS formatted_laptime, " +
                "l.speed_st "+
            "FROM lap AS l " +
                "INNER JOIN compound AS c ON l.compound_id = c.compound_id " +
                "INNER JOIN dta ON l.dta_id = dta.dta_id " +
                "INNER JOIN event_session AS es ON dta.event_session_id = es.event_session_id " +
                "INNER JOIN session_name AS sn ON es.session_name_id = sn.session_name_id " +
                "INNER JOIN event_round AS er ON es.event_round_id = er.event_round_id " +
                "INNER JOIN driver AS d ON dta.driver_id = d.driver_id " +
            "WHERE " +
                "er.year = :year "+
                "AND er.round_number = :roundNumber "+
                "AND es.session_name_id = :sessionNameId "+
                "AND l.lap_number > :lapNumber-10 "+
                "AND l.lap_number <= :lapNumber "+
                "AND d.driver_number = :driverNumber "+
            "ORDER BY lap_start_date ",
            nativeQuery = true
    )
    List<LapDriverDataLastTenDto> findLastTenLapPerDriver(Integer year, Integer roundNumber, Integer sessionNameId, Short lapNumber, Short driverNumber);

@Query(value =
        "WITH subquery AS ( " +
            "SELECT " +
                "l.lap_start_date, " +
                "d.driver_abbreviation, " +
                "d.driver_hex_color, " +
                "d.driver_number, " +
                "l.lap_number, " +
                "c.compound_name, " +
                "CASE " +
                    "WHEN :sectorNumber = 1 THEN ROUND(l.sector1_time / 1000.0, 3) " +
                    "WHEN :sectorNumber = 2 THEN ROUND(l.sector2_time / 1000.0, 3) " +
                    "WHEN :sectorNumber = 3 THEN ROUND(l.sector3_time / 1000.0, 3) " +
                    "ELSE 0.0 " +
                "END AS sector_time_s, " +
                "CASE " +
                    "WHEN :sectorNumber = 1 THEN MIN(l.sector1_time) OVER () / 1000.0 " +
                    "WHEN :sectorNumber = 2 THEN MIN(l.sector2_time) OVER () / 1000.0 " +
                    "WHEN :sectorNumber = 3 THEN MIN(l.sector3_time) OVER () / 1000.0 " +
                    "ELSE 0.0 " +
                "END AS min_sector_time_s, " +
                "CASE " +
                    "WHEN :sectorNumber = 1 THEN ROUND((l.sector1_time - MIN(l.sector1_time) OVER ()) / 1000.0, 3) " +
                    "WHEN :sectorNumber = 2 THEN ROUND((l.sector2_time - MIN(l.sector2_time) OVER ()) / 1000.0, 3) " +
                    "WHEN :sectorNumber = 3 THEN ROUND((l.sector3_time - MIN(l.sector3_time) OVER ()) / 1000.0, 3) " +
                    "ELSE 999.0 " +
                "END AS gap_s, " +
                "CASE " +
                    "WHEN :sectorNumber = 1 THEN ROW_NUMBER() OVER (PARTITION BY d.driver_abbreviation ORDER BY l.sector1_time ASC) " +
                    "WHEN :sectorNumber = 2 THEN ROW_NUMBER() OVER (PARTITION BY d.driver_abbreviation ORDER BY l.sector2_time ASC) " +
                    "WHEN :sectorNumber = 3 THEN ROW_NUMBER() OVER (PARTITION BY d.driver_abbreviation ORDER BY l.sector3_time ASC) " +
                    "ELSE 999 " +
                "END AS rn " +
            "FROM lap AS l " +
                "INNER JOIN compound AS c ON l.compound_id = c.compound_id " +
                "INNER JOIN dta ON l.dta_id = dta.dta_id " +
                "INNER JOIN event_session AS es ON dta.event_session_id = es.event_session_id " +
                "INNER JOIN session_name AS sn ON es.session_name_id = sn.session_name_id " +
                "INNER JOIN event_round AS er ON es.event_round_id = er.event_round_id " +
                "INNER JOIN driver AS d ON dta.driver_id = d.driver_id " +
            "WHERE " +
                "er.year = :year "+
                "AND er.round_number = :roundNumber "+
                "AND l.lap_number <= :lapNumber "+
                "AND ( " +
                    "(:sectorNumber = 1 AND sector1_time <> 0) OR " +
                    "(:sectorNumber = 2 AND sector2_time <> 0) OR " +
                    "(:sectorNumber = 3 AND sector3_time <> 0) " +
                ") " +
            "GROUP BY " +
                "d.driver_number, " +
                "d.driver_abbreviation, " +
                "d.driver_hex_color, " +
                "c.compound_name, " +
                "l.lap_start_date, " +
                "l.lap_number, " +
                "l.sector1_time, " +
                "l.sector2_time, " +
                "l.sector3_time " +
                ") " +

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
        "FROM subquery " +
        "WHERE rn = 1 " +
        "ORDER BY " +
            "gap_s;",
        nativeQuery = true
)
List<LapDriverDataSectorDto> findFastestSector(Integer year, Integer roundNumber, Integer sessionNameId, Short lapNumber, Short sectorNumber);

@Query(value =
        "WITH subquery AS ( " +
            "SELECT " +
                "l.lap_start_date, " +
                "d.driver_abbreviation, " +
                "d.driver_hex_color, " +
                "d.driver_number, " +
                "l.lap_number, " +
                "c.compound_name, " +
                "laptime_ms, " +
                "CONCAT( " +
                    "FLOOR(l.laptime_ms / 60000), " +
                    "':' ," +
                "LPAD( " +
                    "CAST(FLOOR((l.laptime_ms % 60000) / 1000) AS TEXT), " +
                        "2, " +
                        "'0' " +
                "), " +
                "'.'," +
                "LPAD( " +
                    "CAST((l.laptime_ms % 1000) AS TEXT), " +
                        "3, " +
                        "'0' " +
                ") " +
                ") AS formatted_laptime, " +
                "ROUND((laptime_ms - MIN(laptime_ms) OVER ()) / 1000.0, 3) AS gap_s, " +
                "ROW_NUMBER() OVER (PARTITION BY driver_abbreviation ORDER BY laptime_ms ASC) as rn " +
            "FROM lap AS l " +
                "INNER JOIN compound AS c ON l.compound_id = c.compound_id " +
                "INNER JOIN dta ON l.dta_id = dta.dta_id " +
                "INNER JOIN event_session AS es ON dta.event_session_id = es.event_session_id " +
                "INNER JOIN session_name AS sn ON es.session_name_id = sn.session_name_id " +
                "INNER JOIN event_round AS er ON es.event_round_id = er.event_round_id " +
                "INNER JOIN driver AS d ON dta.driver_id = d.driver_id " +
            "WHERE " +
                "er.year = :year "+
                "AND er.round_number = :roundNumber "+
                "AND l.lap_number <= :lapNumber "+
                "AND laptime_ms <> 0 " +
            "GROUP BY " +
                "l.lap_start_date, " +
                "d.driver_number, " +
                "d.driver_abbreviation, " +
                "d.driver_hex_color, " +
                "c.compound_name, " +
                "l.lap_start_date, " +
                "l.lap_number, " +
                "l.laptime_ms " +
                ") " +

        "SELECT " +
            "lap_start_date, " +
            "driver_abbreviation, " +
            "driver_hex_color, " +
            "driver_number, " +
            "lap_number, " +
            "formatted_laptime, " +
            "CAST(gap_s AS DOUBLE PRECISION) as gap_s, " +
            "CAST(ROUND((gap_s * 1000 / min(laptime_ms)), 3) * 100 AS DOUBLE PRECISION) as gap_percentage, " +
            "compound_name "+
        "FROM subquery " +
        "WHERE rn = 1 " +
        "GROUP BY " +
            "lap_start_date, " +
            "driver_number, " +
            "driver_abbreviation, " +
            "driver_hex_color, " +
            "compound_name, " +
            "lap_start_date, " +
            "lap_number, " +
            "laptime_ms, " +
            "formatted_laptime, " +
            "gap_s " +
        "ORDER BY " +
            "gap_s;",
        nativeQuery = true
)
List<LapDriverDataLapDto> findFastestLap(Integer year, Integer roundNumber, Integer sessionNameId, Short lapNumber);

@Query(value =
        "WITH subquery AS ( " +
            "SELECT " +
                "d.driver_abbreviation, " +
                "d.driver_number, " +
                "d.driver_hex_color, " +
                "l.sector1_time, " +
                "l.sector2_time, " +
                "l.sector3_time " +
            "FROM lap AS l " +
                "INNER JOIN compound AS c ON l.compound_id = c.compound_id " +
                "INNER JOIN dta ON l.dta_id = dta.dta_id " +
                "INNER JOIN event_session AS es ON dta.event_session_id = es.event_session_id " +
                "INNER JOIN session_name AS sn ON es.session_name_id = sn.session_name_id " +
                "INNER JOIN event_round AS er ON es.event_round_id = er.event_round_id " +
                "INNER JOIN driver AS d ON dta.driver_id = d.driver_id " +
            "WHERE " +
                "er.year = :year "+
                "AND er.round_number = :roundNumber " +
                "AND l.lap_number <= :lapNumber " +
                "AND l.sector1_time <> 0 " +
                "AND l.sector2_time <> 0 " +
                "AND l.sector3_time <> 0 " +
                ") " +

        "SELECT " +
            "driver_abbreviation, " +
            "driver_number, " +
            "driver_hex_color, " +
            "CONCAT( " +
                "FLOOR((MIN(sector1_time) + MIN(sector2_time) + MIN(sector3_time)) / 60000), " +
                "':' ," +
            "LPAD( " +
                "CAST(FLOOR(((MIN(sector1_time) + MIN(sector2_time) + MIN(sector3_time)) % 60000) / 1000) AS TEXT), " +
                "2, " +
                    "'0' " +
                    "), " +
                "'.'," +
            "LPAD( " +
                "CAST(((MIN(sector1_time) + MIN(sector2_time) + MIN(sector3_time)) % 1000) AS TEXT), " +
                "3, " +
                    "'0' " +
                    ") " +
            ") AS formatted_laptime, " +
            "CAST (" +
                "ROUND( " +
                    "(MIN(sector1_time) + MIN(sector2_time) + MIN(sector3_time)) - " +
                        "MIN(ROUND(MIN(sector1_time) + MIN(sector2_time) + MIN(sector3_time), 3)) OVER (), " +
                    "3 " +
                ") /1000 " +
            "AS DOUBLE PRECISION) AS gap, " +
            "CAST (" +
                "ROUND ( " +
                "( " +
                    "((MIN(sector1_time) + MIN(sector2_time) + MIN(sector3_time)) - " +
                    "MIN(ROUND(MIN(sector1_time) + MIN(sector2_time) + MIN(sector3_time), 3)) OVER ()) / " +
                    "MIN(ROUND(MIN(sector1_time) + MIN(sector2_time) + MIN(sector3_time), 3)) OVER () " +
                ") * 100, 2 ) " +
            "AS DOUBLE PRECISION) AS gap_percentage " +
        "FROM subquery " +
        "GROUP BY " +
            "driver_abbreviation, " +
            "driver_number, " +
            "driver_hex_color " +
        "ORDER BY " +
            "gap ASC;",
        nativeQuery = true
)
List<LapDriverDataTheoreticalLapDto> findTheoreticalFastestLap(Integer year, Integer roundNumber, Integer sessionNameId, Short lapNumber);

}
