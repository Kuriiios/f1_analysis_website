package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.session.Session;
import com.kurios.f1_analysis.session.SessionRepository;
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

    private final SessionRepository sessionRepository;

    private final WeatherMapper weatherMapper;

    public WeatherService(WeatherRepository weatherRepository, SessionRepository sessionRepository, WeatherMapper weatherMapper) {
        this.weatherRepository = weatherRepository;
        this.sessionRepository = sessionRepository;
        this.weatherMapper = weatherMapper;
    }

    public WeatherResponseDto save(WeatherDto weatherDto) {
        var session = sessionRepository.findById(weatherDto.sessionId())
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

    @Transactional
    public void saveWeathersForRoundNumber(Integer year, Integer roundNumber) {
        String url = "http://127.0.0.1:8000/weathers/" + year + "/" + roundNumber;
        ResponseEntity<WeatherDto[]> response =
                restTemplate.getForEntity(url, WeatherDto[].class);

        WeatherDto[] weatherDtos = response.getBody();
    }

}
