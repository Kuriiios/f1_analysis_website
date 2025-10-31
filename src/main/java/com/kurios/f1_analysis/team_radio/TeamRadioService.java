package com.kurios.f1_analysis.team_radio;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamRadioService {

    private final TeamRadioRepository teamRadioRepository;

    private final TeamRadioMapper teamRadioMapper;

    public TeamRadioService(TeamRadioRepository teamRadioRepository, TeamRadioMapper teamRadioMapper) {
        this.teamRadioRepository = teamRadioRepository;
        this.teamRadioMapper = teamRadioMapper;
    }

    public List<TeamRadioResponseDto> findAll(){
        return teamRadioRepository.findAll()
                .stream()
                .map(teamRadioMapper::toTeamRadioResponseDto)
                .collect(Collectors.toList());
    }
}
