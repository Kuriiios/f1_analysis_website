package com.kurios.f1_analysis.team_radio;

import org.springframework.stereotype.Service;

@Service
public class TeamRadioMapper {

    public TeamRadioResponseDto toTeamRadioResponseDto(TeamRadio teamRadio) {
        return new TeamRadioResponseDto(
                teamRadio.getDateTime(),
                teamRadio.getTeamRadioMessage(),
                teamRadio.getTeamRadioUrl()
        );
    }
}
