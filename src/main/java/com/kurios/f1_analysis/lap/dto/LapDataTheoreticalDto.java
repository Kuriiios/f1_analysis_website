package com.kurios.f1_analysis.lap.dto;

public class LapDataTheoreticalDto {
    private String driverAbbreviation;
    private Short driverNumber;
    private String driverHexColor;
    private String formattedLapTime;
    private Double gap;
    private Double gapPercentage;

    public LapDataTheoreticalDto(
            String driverAbbreviation,
            Short driverNumber,
            String driverHexColor,
            String formattedLapTime,
            Double gap,
            Double gapPercentage
    ) {
        this.driverAbbreviation = driverAbbreviation;
        this.driverNumber = driverNumber;
        this.driverHexColor = driverHexColor;
        this.formattedLapTime = formattedLapTime;
        this.gap = gap;
        this.gapPercentage = gapPercentage;
    }

    public String getDriverAbbreviation() {
        return driverAbbreviation;
    }

    public void setDriverAbbreviation(String driverAbbreviation) {
        this.driverAbbreviation = driverAbbreviation;
    }

    public Short getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(Short driverNumber) {
        this.driverNumber = driverNumber;
    }

    public String getDriverHexColor() {
        return driverHexColor;
    }

    public void setDriverHexColor(String driverHexColor) {
        this.driverHexColor = driverHexColor;
    }

    public String getFormattedLapTime() {
        return formattedLapTime;
    }

    public void setFormattedLapTime(String formattedLapTime) {
        this.formattedLapTime = formattedLapTime;
    }

    public Double getGap() {
        return gap;
    }

    public void setGap(Double gap) {
        this.gap = gap;
    }

    public Double getGapPercentage() {
        return gapPercentage;
    }

    public void setGapPercentage(Double gapPercentage) {
        this.gapPercentage = gapPercentage;
    }
}