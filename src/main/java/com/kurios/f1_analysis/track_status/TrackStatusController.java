package com.kurios.f1_analysis.track_status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/track-status")
public class TrackStatusController {

    private final TrackStatusService trackStatusService;

    public TrackStatusController(TrackStatusService trackStatusService) {
        this.trackStatusService = trackStatusService;
    }

    @GetMapping("")
    public List<TrackStatusResponseDto> findAll() {
        return trackStatusService.findAll();
    }

    @GetMapping("/{id}")
    public TrackStatusResponseDto findById(@PathVariable Integer id) {
        return trackStatusService.findById(id);
    }
}
