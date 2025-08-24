package com.kurios.f1_analysis.pos_data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PosDataController {

    private final PosDataRepository posDataRepository;

    public PosDataController(PosDataRepository posDataRepository) {
        this.posDataRepository = posDataRepository;
    }

    @PostMapping("/pos-data")
    public PosData create(@RequestBody PosData posData) {
        return posDataRepository.save(posData);
    }

    @GetMapping("/pos-data")
    public List<PosData> findAll() {
        return posDataRepository.findAll();
    }
}
