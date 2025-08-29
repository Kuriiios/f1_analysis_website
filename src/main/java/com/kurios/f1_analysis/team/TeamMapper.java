package com.kurios.f1_analysis.team;

import org.springframework.stereotype.Service;

@Service
public class TeamMapper {

    public Team toTeam(TeamDto teamDto) {
        return new Team(
                teamDto.teamName(),
                teamDto.teamAbbreviation(),
                teamDto.teamHexColor()
        );
    }

    public TeamDto toTeamDto(Team team) {
        return new TeamDto(
                team.getTeamName(),
                team.getTeamAbbreviation(),
                team.getTeamHexColor()
        );
    }
}
