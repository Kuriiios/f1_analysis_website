package com.kurios.f1_analysis.lap;

import java.util.Date;

public class LapDriverDataSector1Dto {
    private Date lapStartDate;
    private String driverAbbreviation;
    private String driverHexColor;
    private Short driverNumber;
    private Short lapNumber;
    private Double sector1TimeS;
    private Double gapS;
    private Double gapPercentage;
    private String compound_name;

    public LapDriverDataSector1Dto(
            Date lapStartDate,
            String driverAbbreviation,
            String driverHexColor,
            Short driverNumber,
            Short lapNumber,
            Double sector1TimeS,
            Double gapS,
            Double gapPercentage,
            String compound_name ){

        this.lapStartDate = lapStartDate;
        this.driverAbbreviation = driverAbbreviation;
        this.driverHexColor = driverHexColor;
        this.driverNumber = driverNumber;
        this.lapNumber = lapNumber;
        this.sector1TimeS = sector1TimeS;
        this.gapS = gapS;
        this.gapPercentage = gapPercentage;
        this.compound_name = compound_name;
    }

    public Date getLapStartDate() {
        return lapStartDate;
    }

    public void setLapStartDate(Date lapStartDate) {
        this.lapStartDate = lapStartDate;
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

    public Double getSector1TimeS() {
        return sector1TimeS;
    }

    public void setSector1TimeS(Double sector1TimeS) {
        this.sector1TimeS = sector1TimeS;
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

    public String getCompound_name() {
        return compound_name;
    }

    public void setCompound_name(String compound_name) {
        this.compound_name = compound_name;
    }
}