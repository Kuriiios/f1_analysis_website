package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.weather.dto.WeatherDataDto;
import com.kurios.f1_analysis.weather.dto.WeatherResponseDto;
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

    @GetMapping("/all")
    public List<WeatherResponseDto> findAll() {
        return this.weatherService.findAll();
    }

    @GetMapping("")
    public List<WeatherDataDto> findWeatherDataPerSession(
            @RequestParam("year") Integer year,
            @RequestParam("roundNumber") Integer roundNumber,
            @RequestParam("sessionNameId") Integer sessionNameId){
        return weatherService.findWeatherDataPerSession(year, roundNumber, sessionNameId);
    }
}
