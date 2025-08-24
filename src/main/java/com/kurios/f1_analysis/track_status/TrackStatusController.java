package com.kurios.f1_analysis.track_status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrackStatusController {

    private final TrackStatusRepository trackStatusRepository;

    public TrackStatusController(TrackStatusRepository trackStatusRepository) {
        this.trackStatusRepository = trackStatusRepository;
    }

    @PostMapping("/track-status")
    public TrackStatus create(@RequestBody TrackStatus trackStatus) {
        return trackStatusRepository.save(trackStatus);
    }

    @GetMapping("/track-status")
    public List<TrackStatus> findAll() {
        return trackStatusRepository.findAll();
    }
}
