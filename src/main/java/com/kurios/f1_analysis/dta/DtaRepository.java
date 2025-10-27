package com.kurios.f1_analysis.dta;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DtaRepository extends JpaRepository<Dta, Integer> {

    List<Dta> findAllByEventSessionId(Integer sessionId);

    List<Dta> findAllByDriverId(Integer driverId);

    List<Dta> findAllByTeamId(Integer teamId);
}
