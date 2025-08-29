package com.kurios.f1_analysis.track_status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrackStatusController {

    private final TrackStatusService trackStatusService;

    public TrackStatusController(TrackStatusService trackStatusService) {
        this.trackStatusService = trackStatusService;
    }

    @GetMapping("/track-status")
    public List<TrackStatusResponseDto> findAll() {
        return trackStatusService.findAll();
    }
}
