package com.kurios.f1_analysis.sessions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionsController {

    private final SessionsService sessionsService;

    public SessionsController(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }

    @PostMapping("/sessions")
    public SessionsResponseDto create(@RequestBody SessionsDto sessionsDto) {
        return this.sessionsService.create(sessionsDto);
    }

    @GetMapping("/sessions")
    public List<SessionsResponseDto> findAll() {
        return sessionsService.findAll();
    }
}
