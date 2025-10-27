package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.event_session.EventSession;
import org.springframework.stereotype.Service;

@Service
public class WeatherMapper {

    public Weather toWeather(WeatherDto weatherDto, EventSession eventSession) {
        return new Weather(
                eventSession,
                weatherDto.time(),
                weatherDto.windDirection(),
                weatherDto.airTemp(),
                weatherDto.humidity(),
                weatherDto.pressure(),
                weatherDto.rainfall(),
                weatherDto.trackTemp(),
                weatherDto.windSpeed()
        );
    }

    public WeatherResponseDto toWeatherResponseDto(Weather weather) {
        return new WeatherResponseDto(
                weather.getWeather().getId(),
                weather.getTime(),
                weather.getWindDirection(),
                weather.getAirTemp(),
                weather.getHumidity(),
                weather.getPressure(),
                weather.getRainfall(),
                weather.getTrackTemp(),
                weather.getWindSpeed()
        );
    }
}
