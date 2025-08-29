package com.kurios.f1_analysis.team;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    private final TeamMapper teamMapper;

    public TeamService(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public TeamDto create(TeamDto teamDto) {
        var team = teamMapper.toTeam(teamDto);
        teamRepository.save(team);
        return teamDto;
    }

    public List<TeamDto> findAll() {
        return teamRepository.findAll()
                .stream()
                .map(teamMapper::toTeamDto)
                .collect(Collectors.toList());
    }
}
