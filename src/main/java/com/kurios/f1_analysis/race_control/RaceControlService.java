package com.kurios.f1_analysis.race_control;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaceControlService {

    private final RaceControlRepository raceControlRepository;

    private final RaceControlMapper raceControlMapper;

    public RaceControlService(RaceControlRepository raceControlRepository, RaceControlMapper raceControlMapper) {
        this.raceControlRepository = raceControlRepository;
        this.raceControlMapper = raceControlMapper;
    }

    public List<RaceControlResponseDto> findAll(){
        return raceControlRepository.findAll()
                .stream()
                .map(raceControlMapper::toRaceControlResponseDto)
                .collect(Collectors.toList());
    }
}
