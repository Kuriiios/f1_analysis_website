package com.kurios.f1_analysis.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    private final WeatherRepository weatherRepository;

    public WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @PostMapping("/weather")
    public Weather create(@RequestBody Weather weather) {
        return weatherRepository.save(weather);
    }

    @GetMapping("/weather")
    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }
}
