package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.event_round.EventRoundResponseDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("")
    public WeatherResponseDto create(@Valid @RequestBody WeatherDto weatherDto) {
        return this.weatherService.save(weatherDto);
    }

    @GetMapping("")
    public List<WeatherResponseDto> findAll() {
        return this.weatherService.findAll();
    }

    @GetMapping("/{id}")
    public WeatherResponseDto findById(@PathVariable Integer id) {
        return weatherService.findById(id);
    }
}
