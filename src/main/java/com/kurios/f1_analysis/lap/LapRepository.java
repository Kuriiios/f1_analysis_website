package com.kurios.f1_analysis.lap;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LapRepository extends JpaRepository<Lap, Integer> {

    List<Lap> findAllByDriverTeamAssignment_Id(Integer dtaId);
}
