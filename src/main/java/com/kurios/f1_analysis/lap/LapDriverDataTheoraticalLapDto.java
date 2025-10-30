package com.kurios.f1_analysis.lap;

public class LapDriverDataTheoraticalLapDto {
    private String driverAbbreviation;
    private Short driverNumber;
    private String driverHexColor;
    private Double theoreticalLapTimeS;
    private Double gapS;
    private Double gapPercentage;

    public LapDriverDataTheoraticalLapDto(String driverAbbreviation, Short driverNumber, String driverHexColor, Double theoraticalLapTimeS, Double gapS, Double gapPercentage) {
        this.driverAbbreviation = driverAbbreviation;
        this.driverNumber = driverNumber;
        this.driverHexColor = driverHexColor;
        this.theoreticalLapTimeS = theoraticalLapTimeS;
        this.gapS = gapS;
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

    public Double getTheoraticalLapTimeS() {
        return theoreticalLapTimeS;
    }

    public void setTheoraticalLapTimeS(Double theoraticalLapTimeS) {
        this.theoreticalLapTimeS = theoraticalLapTimeS;
    }

    public Double getGapS() {
        return gapS;
    }

    public void setGapS(Double gapS) {
        this.gapS = gapS;
    }

    public Double getGapPercentage() {
        return gapPercentage;
    }

    public void setGapPercentage(Double gapPercentage) {
        this.gapPercentage = gapPercentage;
    }
}