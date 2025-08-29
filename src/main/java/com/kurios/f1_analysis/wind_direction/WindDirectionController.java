package com.kurios.f1_analysis.wind_direction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WindDirectionController {

    private final WindDirectionService windDirectionService;

    public WindDirectionController(WindDirectionService windDirectionService) {
        this.windDirectionService = windDirectionService;
    }

    @GetMapping("/wind-direction")
    public List<WindDirectionResponseDto> findAll() {
        return windDirectionService.findAll();
    }
}
