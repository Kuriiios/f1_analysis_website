package com.kurios.f1_analysis.race_control;

import org.springframework.stereotype.Service;

@Service
public class RaceControlMapper {

    public RaceControlResponseDto toRaceControlResponseDto(RaceControl raceControl){
        return new RaceControlResponseDto(
                raceControl.getRaceControlId(),
                raceControl.getDateTime(),
                raceControl.getRaceControlMessage()
        );
    }
}
