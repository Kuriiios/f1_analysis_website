package com.kurios.f1_analysis.lap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LapController {

    private LapService lapService;

    public LapController(LapService lapService) {
        this.lapService = lapService;
    }

    @PostMapping("/lap")
    public LapResponseDto create(@RequestBody LapDto lapDto) {
        return lapService.create(lapDto);
    }

    @GetMapping("/lap")
    public List<LapResponseDto> findAll() {
        return lapService.findAll();
    }
}
