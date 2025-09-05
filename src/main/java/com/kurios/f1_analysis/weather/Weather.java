package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.session.Session;
import com.kurios.f1_analysis.wind_direction.WindDirection;
import jakarta.persistence.*;

@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "weather_id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name= "session_id")
    private Session weather;

    @ManyToOne()
    @JoinColumn(name= "wind_direction_id")
        private WindDirection windDirection;

    private Short airTemp;

    private Short humidity;

    private Short pressure;

    private Boolean isRainfall;

    private Short trackTemp;

    private Short windSpeed;

    public Weather() {
    }

    public Weather(Session weather, WindDirection windDirection, Short airTemp, Short humidity, Short pressure, Boolean isRainfall, Short trackTemp, Short windSpeed) {
        this.weather = weather;
        this.windDirection = windDirection;
        this.airTemp = airTemp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.isRainfall = isRainfall;
        this.trackTemp = trackTemp;
        this.windSpeed = windSpeed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Session getWeather() {
        return weather;
    }

    public void setWeather(Session weather) {
        this.weather = weather;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public Short getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(Short airTemp) {
        this.airTemp = airTemp;
    }

    public Short getHumidity() {
        return humidity;
    }

    public void setHumidity(Short humidity) {
        this.humidity = humidity;
    }

    public Short getPressure() {
        return pressure;
    }

    public void setPressure(Short pressure) {
        this.pressure = pressure;
    }

    public Boolean getRainfall() {
        return isRainfall;
    }

    public void setRainfall(Boolean rainfall) {
        isRainfall = rainfall;
    }

    public Short getTrackTemp() {
        return trackTemp;
    }

    public void setTrackTemp(Short trackTemp) {
        this.trackTemp = trackTemp;
    }

    public Short getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Short windSpeed) {
        this.windSpeed = windSpeed;
    }
}
