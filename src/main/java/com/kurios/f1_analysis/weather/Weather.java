package com.kurios.f1_analysis.weather;

import com.kurios.f1_analysis.event_session.EventSession;
import jakarta.persistence.*;

@Entity
@Table(name = "weather", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"event_session_id", "time", "wind_direction", "air_temp", "humidity", "pressure", "is_rainfall", "track_temp", "wind_speed"})
})
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "weather_id", unique=true)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name= "event_session_id")
    private EventSession weather;

    private Integer time;

    private Short windDirection;

    private Short airTemp;

    private Short humidity;

    private Short pressure;

    private Boolean isRainfall;

    private Short trackTemp;

    private Short windSpeed;

    public Weather() {
    }

    public Weather(EventSession weather, Integer time, Short windDirection, Short airTemp, Short humidity, Short pressure, Boolean isRainfall, Short trackTemp, Short windSpeed) {
        this.weather = weather;
        this.time = time;
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public EventSession getWeather() {
        return weather;
    }

    public void setWeather(EventSession weather) {
        this.weather = weather;
    }

    public Short getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Short windDirection) {
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
