package com.kurios.f1_analysis.lap;

import com.kurios.f1_analysis.compound.Compound;
import com.kurios.f1_analysis.dta.Dta;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "lap", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"compound_id", "dta_id", "track_status", "laptime_ms", "lap_number", "lap_start_time", "lap_start_date"})
})
public class Lap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lap_id", unique=true)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name= "compound_id")
    private Compound compound;

    @ManyToOne()
    @JoinColumn(name= "dta_id")
    private Dta dta;

    private Integer trackStatus;

    @Column(name = "laptime_ms")
    private Integer laptimeMs;

    private Short lapNumber;

    private Short stint;

    private Integer pitInTime;

    private Integer pitOutTime;

    @Column(name = "sector1_time")
    private Integer sector1Time;

    @Column(name = "sector2_time")
    private Integer sector2Time;

    @Column(name = "sector3_time")
    private Integer sector3Time;

    @Column(name = "sector1_session_time")
    private Integer sector1SessionTime;

    @Column(name = "sector2_session_time")
    private Integer sector2SessionTime;

    @Column(name = "sector3_session_time")
    private Integer sector3SessionTime;

    @Column(name = "speed_i1")
    private Short speedI1;

    @Column(name = "speed_i2")
    private Short speedI2;

    private Short speedFl;

    private Short speedSt;

    private Boolean isPersonalBest;

    private Short tyreLife;

    private Integer lapStartTime;

    private Date lapStartDate;

    private Short position;

    private Boolean isDeleted;

    private Boolean isAccurate;

    public Lap() {
    }

    public Lap(Compound compound, Dta dta, Integer trackStatus, Integer laptimeMs, Short lapNumber, Short stint, Integer pitInTime, Integer pitOutTime, Integer sector1Time, Integer sector2Time, Integer sector3Time, Integer sector1SessionTime, Integer sector2SessionTime, Integer sector3SessionTime, Short speedI1, Short speedI2, Short speedFl, Short speedSt, Boolean isPersonalBest, Short tyreLife, Integer lapStartTime, Date lapStartDate, Short position, Boolean isDeleted, Boolean isAccurate) {
        this.compound = compound;
        this.dta = dta;
        this.trackStatus = trackStatus;
        this.laptimeMs = laptimeMs;
        this.lapNumber = lapNumber;
        this.stint = stint;
        this.pitInTime = pitInTime;
        this.pitOutTime = pitOutTime;
        this.sector1Time = sector1Time;
        this.sector2Time = sector2Time;
        this.sector3Time = sector3Time;
        this.sector1SessionTime = sector1SessionTime;
        this.sector2SessionTime = sector2SessionTime;
        this.sector3SessionTime = sector3SessionTime;
        this.speedI1 = speedI1;
        this.speedI2 = speedI2;
        this.speedFl = speedFl;
        this.speedSt = speedSt;
        this.isPersonalBest = isPersonalBest;
        this.tyreLife = tyreLife;
        this.lapStartTime = lapStartTime;
        this.lapStartDate = lapStartDate;
        this.position = position;
        this.isDeleted = isDeleted;
        this.isAccurate = isAccurate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAccurate() {
        return isAccurate;
    }

    public void setAccurate(Boolean accurate) {
        isAccurate = accurate;
    }

    public Boolean getPersonalBest() {
        return isPersonalBest;
    }

    public void setPersonalBest(Boolean personalBest) {
        isPersonalBest = personalBest;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Short getPosition() {
        return position;
    }

    public void setPosition(Short position) {
        this.position = position;
    }

    public Date getLapStartDate() {
        return lapStartDate;
    }

    public void setLapStartDate(Date lapStartDate) {
        this.lapStartDate = lapStartDate;
    }

    public Integer getLapStartTime() {
        return lapStartTime;
    }

    public void setLapStartTime(Integer lapStartTime) {
        this.lapStartTime = lapStartTime;
    }

    public Short getTyreLife() {
        return tyreLife;
    }

    public void setTyreLife(Short tyreLife) {
        this.tyreLife = tyreLife;
    }

    public Boolean getisPersonalBest() {
        return isPersonalBest;
    }

    public void setisPersonalBest(Boolean isPersonalBest) {
        this.isPersonalBest = isPersonalBest;
    }

    public Short getSpeedSt() {
        return speedSt;
    }

    public void setSpeedSt(Short speedSt) {
        this.speedSt = speedSt;
    }

    public Short getSpeedFl() {
        return speedFl;
    }

    public void setSpeedFl(Short speedFl) {
        this.speedFl = speedFl;
    }

    public Short getSpeedI2() {
        return speedI2;
    }

    public void setSpeedI2(Short speedI2) {
        this.speedI2 = speedI2;
    }

    public Short getSpeedI1() {
        return speedI1;
    }

    public void setSpeedI1(Short speedI1) {
        this.speedI1 = speedI1;
    }

    public Integer getSector3SessionTime() {
        return sector3SessionTime;
    }

    public void setSector3SessionTime(Integer sector3SessionTime) {
        this.sector3SessionTime = sector3SessionTime;
    }

    public Integer getSector2SessionTime() {
        return sector2SessionTime;
    }

    public void setSector2SessionTime(Integer sector2SessionTime) {
        this.sector2SessionTime = sector2SessionTime;
    }

    public Integer getSector1SessionTime() {
        return sector1SessionTime;
    }

    public void setSector1SessionTime(Integer sector1SessionTime) {
        this.sector1SessionTime = sector1SessionTime;
    }

    public Integer getSector3Time() {
        return sector3Time;
    }

    public void setSector3Time(Integer sector3Time) {
        this.sector3Time = sector3Time;
    }

    public Integer getSector2Time() {
        return sector2Time;
    }

    public void setSector2Time(Integer sector2Time) {
        this.sector2Time = sector2Time;
    }

    public Integer getSector1Time() {
        return sector1Time;
    }

    public void setSector1Time(Integer sector1Time) {
        this.sector1Time = sector1Time;
    }

    public Integer getPitOutTime() {
        return pitOutTime;
    }

    public void setPitOutTime(Integer pitOutTime) {
        this.pitOutTime = pitOutTime;
    }

    public Integer getPitInTime() {
        return pitInTime;
    }

    public void setPitInTime(Integer pitInTime) {
        this.pitInTime = pitInTime;
    }

    public Short getStint() {
        return stint;
    }

    public void setStint(Short stint) {
        this.stint = stint;
    }

    public Short getLapNumber() {
        return lapNumber;
    }

    public void setLapNumber(Short lapNumber) {
        this.lapNumber = lapNumber;
    }

    public Integer getLaptimeMs() {
        return laptimeMs;
    }

    public void setLaptimeMs(Integer laptimeMs) {
        this.laptimeMs = laptimeMs;
    }

    public Integer getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(Integer trackStatus) {
        this.trackStatus = trackStatus;
    }

    public Dta getDta() {
        return dta;
    }

    public void setDta(Dta dta) {
        this.dta = dta;
    }

    public Compound getCompound() {
        return compound;
    }

    public void setCompound(Compound compound) {
        this.compound = compound;
    }
}
