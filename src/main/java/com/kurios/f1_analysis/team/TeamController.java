package com.kurios.f1_analysis.team;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping("/team")
    public Team create(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    @GetMapping("/team")
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
