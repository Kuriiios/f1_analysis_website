package com.kurios.f1_analysis.lap;

public class LapDriverDataTheoreticalLapDto {
    private String driverAbbreviation;
    private Short driverNumber;
    private String driverHexColor;
    private String formattedLapTimeS;
    private Double gap;
    private Double gapPercentage;

    public LapDriverDataTheoreticalLapDto(String driverAbbreviation, Short driverNumber, String driverHexColor, String formattedLapTimeS, Double gap, Double gapPercentage) {
        this.driverAbbreviation = driverAbbreviation;
        this.driverNumber = driverNumber;
        this.driverHexColor = driverHexColor;
        this.formattedLapTimeS = formattedLapTimeS;
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

    public String getFormattedLapTimeS() {
        return formattedLapTimeS;
    }

    public void setFormattedLapTimeS(String formattedLapTimeS) {
        this.formattedLapTimeS = formattedLapTimeS;
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