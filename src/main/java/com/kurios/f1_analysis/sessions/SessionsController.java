package com.kurios.f1_analysis.sessions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionsController {

    private final SessionsRepository sessionRepository;

    public SessionsController(SessionsRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @PostMapping("/sessions")
    public Sessions create(@RequestBody Sessions sessions) {
        return sessionRepository.save(sessions);
    }

    @GetMapping("/sessions")
    public List<Sessions> findAll() {
        return sessionRepository.findAll();
    }
}
