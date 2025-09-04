package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.session.Session;
import com.kurios.f1_analysis.wind_direction.WindDirection;
import org.springframework.stereotype.Service;

@Service
public class WeatherMapper {

    public Weather toWeather(WeatherDto weatherDto, Session session, WindDirection windDirection) {
        return new Weather(
                session,
                windDirection,
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
                weather.getWindDirection().getId(),
                weather.getAirTemp(),
                weather.getHumidity(),
                weather.getPressure(),
                weather.getRainfall(),
                weather.getTrackTemp(),
                weather.getWindSpeed()
        );
    }
}
