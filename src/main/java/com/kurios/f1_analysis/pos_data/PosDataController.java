package com.kurios.f1_analysis.pos_data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PosDataController {

    private final PosDataService posDataService;

    public PosDataController(PosDataService posDataService) {
        this.posDataService = posDataService;
    }

    @PostMapping("/pos-data")
    public PosDataResponseDto create(@RequestBody PosDataDto posDataDto) {
        return posDataService.create(posDataDto);
    }

    @GetMapping("/pos-data")
    public List<PosDataResponseDto> findAll() {
        return posDataService.findAll();
    }
}
