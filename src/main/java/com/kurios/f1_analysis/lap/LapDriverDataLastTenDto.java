package com.kurios.f1_analysis.lap;

import java.util.Date;

public class LapDriverDataLastTenDto {
    private Date lapStartDate;
    private Short driverNumber;
    private Short lapNumber;
    private Integer sector1Time;
    private Short speedI1;
    private Integer sector2Time;
    private Short speedI2;
    private Integer sector3Time;
    private Short speedFl;
    private Integer laptimeMs;
    private Short speedSt;

    public LapDriverDataLastTenDto(
            Date lapStartDate, Short lapNumber, Short driverNumber, Integer sector1Time,
            Short speedI1, Integer sector2Time, Short speedI2, Integer sector3Time,
            Short speedFl, Integer laptimeMs, Short speedSt) {

        this.lapStartDate = lapStartDate;
        this.driverNumber = driverNumber;
        this.lapNumber = lapNumber;
        this.sector1Time = sector1Time;
        this.speedI1 = speedI1;
        this.sector2Time = sector2Time;
        this.speedI2 = speedI2;
        this.sector3Time = sector3Time;
        this.speedFl = speedFl;
        this.laptimeMs = laptimeMs;
        this.speedSt = speedSt;
    }

    public Date getLapStartDate() {
        return lapStartDate;
    }

    public void setLapStartDate(Date lapStartDate) {
        this.lapStartDate = lapStartDate;
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

    public Integer getSector1Time() {
        return sector1Time;
    }

    public void setSector1Time(Integer sector1Time) {
        this.sector1Time = sector1Time;
    }

    public Short getSpeedI1() {
        return speedI1;
    }

    public void setSpeedI1(Short speedI1) {
        this.speedI1 = speedI1;
    }

    public Integer getSector2Time() {
        return sector2Time;
    }

    public void setSector2Time(Integer sector2Time) {
        this.sector2Time = sector2Time;
    }

    public Short getSpeedI2() {
        return speedI2;
    }

    public void setSpeedI2(Short speedI2) {
        this.speedI2 = speedI2;
    }

    public Integer getSector3Time() {
        return sector3Time;
    }

    public void setSector3Time(Integer sector3Time) {
        this.sector3Time = sector3Time;
    }

    public Short getSpeedFl() {
        return speedFl;
    }

    public void setSpeedFl(Short speedFl) {
        this.speedFl = speedFl;
    }

    public Integer getLaptimeMs() {
        return laptimeMs;
    }

    public void setLaptimeMs(Integer laptimeMs) {
        this.laptimeMs = laptimeMs;
    }

    public Short getSpeedSt() {
        return speedSt;
    }

    public void setSpeedSt(Short speedSt) {
        this.speedSt = speedSt;
    }
}