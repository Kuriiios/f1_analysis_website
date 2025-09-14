package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.event_round.EventRoundResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/import/{year}/{roundNumber}")
    public ResponseEntity<String> importWeathers(@PathVariable Integer year,
                                                 @PathVariable Short roundNumber){
        weatherService.saveWeathersForRoundNumber(year, (int) roundNumber);
        return ResponseEntity.ok().body("Succesfully imported data from fastF1 to database.");
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
