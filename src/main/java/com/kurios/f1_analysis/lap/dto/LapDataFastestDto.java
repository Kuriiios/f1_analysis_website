package com.kurios.f1_analysis.lap.dto;

import java.util.Date;

public class LapDataFastestDto {
    private Date dateTime;
    private String driverAbbreviation;
    private String driverHexColor;
    private Short driverNumber;
    private Short lapNumber;
    private String formattedLaptime;
    private Double gap;
    private Double gapPercentage;
    private String compound_name;

    public LapDataFastestDto(
            Date dateTime,
            String driverAbbreviation,
            String driverHexColor,
            Short driverNumber,
            Short lapNumber,
            String formattedLaptime,
            Double gap,
            Double gapPercentage,
            String compound_name
    ) {
        this.dateTime = dateTime;
        this.driverAbbreviation = driverAbbreviation;
        this.driverHexColor = driverHexColor;
        this.driverNumber = driverNumber;
        this.lapNumber = lapNumber;
        this.formattedLaptime = formattedLaptime;
        this.gap = gap;
        this.gapPercentage = gapPercentage;
        this.compound_name = compound_name;
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

    public String getFormattedLaptime() {
        return formattedLaptime;
    }

    public void setFormattedLaptime(String formattedLaptime) {
        this.formattedLaptime = formattedLaptime;
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

    public String getCompound_name() {
        return compound_name;
    }

    public void setCompound_name(String compound_name) {
        this.compound_name = compound_name;
    }
}