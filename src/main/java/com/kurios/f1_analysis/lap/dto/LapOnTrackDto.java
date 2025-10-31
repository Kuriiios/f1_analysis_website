package com.kurios.f1_analysis.lap.dto;

public class LapOnTrackDto {
    private Short driverNumber;
    private String status;

    public LapOnTrackDto(
            Short driverNumber,
            String status
    ) {
        this.driverNumber = driverNumber;
        this.status = status;
    }

    public Short getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(Short driverNumber) {
        this.driverNumber = driverNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}