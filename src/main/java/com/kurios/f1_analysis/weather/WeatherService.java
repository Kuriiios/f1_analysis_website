package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.sessions.SessionsRepository;
import com.kurios.f1_analysis.wind_direction.WindDirectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    private final SessionsRepository sessionsRepository;

    private final WeatherMapper weatherMapper;

    private final WindDirectionRepository windDirectionRepository;

    public WeatherService(WeatherRepository weatherRepository, SessionsRepository sessionsRepository, WeatherMapper weatherMapper, WindDirectionRepository windDirectionRepository) {
        this.weatherRepository = weatherRepository;
        this.sessionsRepository = sessionsRepository;
        this.weatherMapper = weatherMapper;
        this.windDirectionRepository = windDirectionRepository;
    }

    public WeatherResponseDto create(WeatherDto weatherDto) {
        var session = sessionsRepository.findById(weatherDto.sessionId())
                .orElseThrow(() -> new RuntimeException("Session not found"));
        var windDirection =  windDirectionRepository.findById(weatherDto.windDirectionId())
                .orElseThrow(() -> new RuntimeException("Wind Direction not found"));
        var weather = weatherMapper.toWeather(weatherDto, session, windDirection);
        var savedWeather= weatherRepository.save(weather);
        var weatherResponseDto = weatherMapper.toWeatherResponseDto(weather);
        return weatherResponseDto;
    }

    public List<WeatherResponseDto> findAll() {
        return weatherRepository.findAll()
                .stream()
                .map(weatherMapper::toWeatherResponseDto)
                .collect(Collectors.toList()
                );
    }

}
