package com.kurios.f1_analysis.team;

import com.kurios.f1_analysis.event_round.EventRoundResponseDto;
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

    public TeamResponseDto save(TeamDto teamDto) {
        var team = teamMapper.toTeam(teamDto);
        var savedTeam = teamRepository.save(team);
        var teamResponseDto = teamMapper.toTeamResponseDto(savedTeam);
        return teamResponseDto;
    }

    public List<TeamResponseDto> findAll() {
        return teamRepository.findAll()
                .stream()
                .map(teamMapper::toTeamResponseDto)
                .collect(Collectors.toList());
    }


    public TeamResponseDto findById(Integer id) {
        return teamRepository.findById(id)
                .map(teamMapper::toTeamResponseDto)
                .orElse(null);
    }
}
