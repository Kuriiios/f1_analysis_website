package com.kurios.f1_analysis.session;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/sessions")
    public SessionResponseDto create(@RequestBody SessionDto sessionDto) {
        return this.sessionService.create(sessionDto);
    }

    @GetMapping("/sessions")
    public List<SessionResponseDto> findAll() {
        return sessionService.findAll();
    }
}
