package com.kurios.f1_analysis.lap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LapController {

    private final LapRepository lapRepository;

    public LapController(LapRepository lapRepository) {
        this.lapRepository = lapRepository;
    }

    @PostMapping("/lap")
    public Lap create(@RequestBody Lap lap) {
        return lapRepository.save(lap);
    }

    @GetMapping("/lap")
    public List<Lap> findAll() {
        return lapRepository.findAll();
    }
}
