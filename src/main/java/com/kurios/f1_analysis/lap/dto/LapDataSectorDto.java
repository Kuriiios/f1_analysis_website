package com.kurios.f1_analysis.lap.dto;

import java.util.Date;

public class LapDataSectorDto {
    private Date dateTime;
    private String driverAbbreviation;
    private String driverHexColor;
    private Short driverNumber;
    private Short lapNumber;
    private Double sectorTime;
    private Double gap;
    private Double gapPercentage;
    private String compoundName;

    public LapDataSectorDto(
            Date dateTime,
            String driverAbbreviation,
            String driverHexColor,
            Short driverNumber,
            Short lapNumber,
            Double sectorTime,
            Double gap,
            Double gapPercentage,
            String compoundName
    ) {
        this.dateTime = dateTime;
        this.driverAbbreviation = driverAbbreviation;
        this.driverHexColor = driverHexColor;
        this.driverNumber = driverNumber;
        this.lapNumber = lapNumber;
        this.sectorTime = sectorTime;
        this.gap = gap;
        this.gapPercentage = gapPercentage;
        this.compoundName = compoundName;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getDriverAbbreviation() {
        return driverAbbreviation;
    }

    public void setDriverAbbreviation(String driverAbbreviation) {
        this.driverAbbreviation = driverAbbreviation;
    }

    public String getDriverHexColor() {
        return driverHexColor;
    }

    public void setDriverHexColor(String driverHexColor) {
        this.driverHexColor = driverHexColor;
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

    public Double getSectorTime() {
        return sectorTime;
    }

    public void setSectorTime(Double sectorTime) {
        this.sectorTime = sectorTime;
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

    public String getCompoundName() {
        return compoundName;
    }

    public void setCompoundName(String compoundName) {
        this.compoundName = compoundName;
    }
}