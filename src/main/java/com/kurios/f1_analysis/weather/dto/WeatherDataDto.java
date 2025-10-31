package com.kurios.f1_analysis.weather.dto;

public class WeatherDataDto {
    private String time;
    private Short airTemp;
    private Short humidity;
    private Short pressure;
    private Boolean isRainfall;
    private Short trackTemp;
    private Short windSpeed;
    private Short windDirection;

    public WeatherDataDto(
            String time,
            Short airTemp,
            Short humidity,
            Short pressure,
            Boolean isRainfall,
            Short trackTemp,
            Short windSpeed,
            Short windDirection
    ) {
        this.time = time;
        this.airTemp = airTemp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.isRainfall = isRainfall;
        this.trackTemp = trackTemp;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public Short getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Short windDirection) {
        this.windDirection = windDirection;
    }
}