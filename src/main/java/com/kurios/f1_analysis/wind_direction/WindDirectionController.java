package com.kurios.f1_analysis.wind_direction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WindDirectionController {

    private final WindDirectionRepository windDirectionRepository;

    public WindDirectionController(WindDirectionRepository windDirectionRepository) {
        this.windDirectionRepository = windDirectionRepository;
    }

    @PostMapping("/wind-direction")
    public WindDirection create(@RequestBody WindDirection windDirection) {
        return windDirectionRepository.save(windDirection);
    }

    @GetMapping("/wind-direction")
    public List<WindDirection> findAll() {
        return windDirectionRepository.findAll();
    }
}
