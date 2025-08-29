package com.kurios.f1_analysis.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/weather")
    public WeatherResponseDto create(@RequestBody WeatherDto weatherDto) {
        return this.weatherService.create(weatherDto);
    }

    @GetMapping("/weather")
    public List<WeatherResponseDto> findAll() {
        return this.weatherService.findAll();
    }
}
