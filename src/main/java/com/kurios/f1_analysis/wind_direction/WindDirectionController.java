package com.kurios.f1_analysis.wind_direction;

import com.kurios.f1_analysis.event_round.EventRoundResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wind-direction")
public class WindDirectionController {

    private final WindDirectionService windDirectionService;

    public WindDirectionController(WindDirectionService windDirectionService) {
        this.windDirectionService = windDirectionService;
    }

    @GetMapping("")
    public List<WindDirectionResponseDto> findAll() {
        return windDirectionService.findAll();
    }

    @GetMapping("/{id}")
    public WindDirectionResponseDto findById(@PathVariable Integer id) {
        return windDirectionService.findById(id);
    }
}
