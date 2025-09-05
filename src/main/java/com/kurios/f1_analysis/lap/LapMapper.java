package com.kurios.f1_analysis.lap;

import com.kurios.f1_analysis.compound.Compound;
import com.kurios.f1_analysis.driver_team_assignment.DriverTeamAssignment;
import com.kurios.f1_analysis.track_status.TrackStatus;
import org.springframework.stereotype.Service;

@Service
public class LapMapper {

    public Lap toLap(LapDto lapDto, DriverTeamAssignment dta, Compound compound, TrackStatus trackStatus) {
        return new Lap(
                compound,
                dta,
                trackStatus,
                lapDto.laptimeS(),
                lapDto.lapNumber(),
                lapDto.stint(),
                lapDto.pitInTime(),
                lapDto.pitOutTime(),
                lapDto.sector1Time(),
                lapDto.sector2Time(),
                lapDto.sector3Time(),
                lapDto.sector1SessionTime(),
                lapDto.sector2SessionTime(),
                lapDto.sector3SessionTime(),
                lapDto.speedI1(),
                lapDto.speedI2(),
                lapDto.speedFl(),
                lapDto.speedSt(),
                lapDto.isPersonalBest(),
                lapDto.tyreLife(),
                lapDto.lapStartTime(),
                lapDto.lapStartDate(),
                lapDto.position(),
                lapDto.isDeleted(),
                lapDto.isAccurate()
        );
    }

    public LapResponseDto toLapResponseDto(Lap lap) {
        return new LapResponseDto(
                lap.getCompound().getId(),
                lap.getDriverTeamAssignment().getId(),
                lap.getTrackStatus().getId(),
                lap.getLaptimeS(),
                lap.getLapNumber(),
                lap.getStint(),
                lap.getPitInTime(),
                lap.getPitOutTime(),
                lap.getSector1Time(),
                lap.getSector2Time(),
                lap.getSector3Time(),
                lap.getSector1SessionTime(),
                lap.getSector2SessionTime(),
                lap.getSector3SessionTime(),
                lap.getSpeedI1(),
                lap.getSpeedI2(),
                lap.getSpeedFl(),
                lap.getSpeedSt(),
                lap.getisPersonalBest(),
                lap.getTyreLife(),
                lap.getLapStartTime(),
                lap.getLapStartDate(),
                lap.getPosition(),
                lap.getDeleted(),
                lap.getAccurate()
        );
    }
}
