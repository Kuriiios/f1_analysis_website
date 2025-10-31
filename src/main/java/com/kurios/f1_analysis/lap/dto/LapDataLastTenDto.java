package com.kurios.f1_analysis.lap.dto;

import java.util.Date;

public class LapDataLastTenDto {
    private Date dateTime;
    private Short driverNumber;
    private Short lapNumber;
    private Double sector1Time;
    private Short speedI1;
    private Double sector2Time;
    private Short speedI2;
    private Double sector3Time;
    private Short speedFl;
    private String formattedLaptime;
    private Short speedSt;

    public LapDataLastTenDto(Date dateTime, Short driverNumber, Short lapNumber, Double sector1Time, Short speedI1, Double sector2Time, Short speedI2, Double sector3Time, Short speedFl, String formattedLaptime, Short speedSt) {
        this.dateTime = dateTime;
        this.driverNumber = driverNumber;
        this.lapNumber = lapNumber;
        this.sector1Time = sector1Time;
        this.speedI1 = speedI1;
        this.sector2Time = sector2Time;
        this.speedI2 = speedI2;
        this.sector3Time = sector3Time;
        this.speedFl = speedFl;
        this.formattedLaptime = formattedLaptime;
        this.speedSt = speedSt;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Short getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(Short driverNumber) {
        this.driverNumber = driverNumber;
    }

    public Short getLapNumber() {
        return lapNumber;
    }

    public void setLapNumber(Short lapNumber) {
        this.lapNumber = lapNumber;
    }

    public Double getSector1Time() {
        return sector1Time;
    }

    public void setSector1Time(Double sector1Time) {
        this.sector1Time = sector1Time;
    }

    public Short getSpeedI1() {
        return speedI1;
    }

    public void setSpeedI1(Short speedI1) {
        this.speedI1 = speedI1;
    }

    public Double getSector2Time() {
        return sector2Time;
    }

    public void setSector2Time(Double sector2Time) {
        this.sector2Time = sector2Time;
    }

    public Short getSpeedI2() {
        return speedI2;
    }

    public void setSpeedI2(Short speedI2) {
        this.speedI2 = speedI2;
    }

    public Double getSector3Time() {
        return sector3Time;
    }

    public void setSector3Time(Double sector3Time) {
        this.sector3Time = sector3Time;
    }

    public Short getSpeedFl() {
        return speedFl;
    }

    public void setSpeedFl(Short speedFl) {
        this.speedFl = speedFl;
    }

    public String getFormattedLaptime() {
        return formattedLaptime;
    }

    public void setFormattedLaptime(String formattedLaptime) {
        this.formattedLaptime = formattedLaptime;
    }

    public Short getSpeedSt() {
        return speedSt;
    }

    public void setSpeedSt(Short speedSt) {
        this.speedSt = speedSt;
    }
}