package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.event_session.EventSessionRepository;
import com.kurios.f1_analysis.weather.dto.WeatherDataDto;
import com.kurios.f1_analysis.weather.dto.WeatherDto;
import com.kurios.f1_analysis.weather.dto.WeatherResponseDto;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private RestTemplate restTemplate = new RestTemplate();

    private final WeatherRepository weatherRepository;

    private final EventSessionRepository eventSessionRepository;

    private final WeatherMapper weatherMapper;

    public WeatherService(WeatherRepository weatherRepository, EventSessionRepository eventSessionRepository, WeatherMapper weatherMapper) {
        this.weatherRepository = weatherRepository;
        this.eventSessionRepository = eventSessionRepository;
        this.weatherMapper = weatherMapper;
    }

    public WeatherResponseDto save(WeatherDto weatherDto) {
        var session = eventSessionRepository.findById(weatherDto.sessionId())
                .orElseThrow(() -> new RuntimeException("Session not found"));
        var weather = weatherMapper.toWeather(weatherDto, session);
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

    public WeatherResponseDto findById(Integer id) {
        return weatherRepository.findById(id)
                .map(weatherMapper::toWeatherResponseDto)
                .orElse(null);
    }

    public List<WeatherDataDto> findWeatherDataPerSession(Integer year, Integer roundNumber, Integer sessionNameId) {
        return weatherRepository.findWeatherDataPerSession(year, roundNumber, sessionNameId);
    }

    @Transactional
    public void saveWeathersForRoundNumber(Integer year, Integer roundNumber) {
        String url = "http://127.0.0.1:8000/weathers/" + year + "/" + roundNumber;
        ResponseEntity<WeatherDto[]> response =
                restTemplate.getForEntity(url, WeatherDto[].class);

        WeatherDto[] weatherDtos = response.getBody();
    }

}
