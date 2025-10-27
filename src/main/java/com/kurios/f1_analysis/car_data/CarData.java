package com.kurios.f1_analysis.car_data;

import com.kurios.f1_analysis.drs.Drs;
import com.kurios.f1_analysis.dta.Dta;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "car_data", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"dta_id", "drs_id", "track_status", "date_time", "time", "session_time", "rpm", "speed", "n_gear", "throttle", "is_braking", "distance", "differential_distance", "relative_distance", "distance_driver_ahead"})
})
public class CarData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_data_id", unique=true)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name= "dta_id")
    private Dta carDataDta;

    @ManyToOne()
    @JoinColumn(name= "drs_id")
    private Drs drs;

    private Integer trackStatus;

    private Date dateTime;

    private Integer time;

    private Integer sessionTime;

    private Short rpm;

    private Short speed;

    private Short nGear;

    private Short throttle;

    private Boolean isBraking;

    private Float distance;

    private Float differentialDistance;

    private Float relativeDistance;

    private Integer distanceDriverAhead;

    public CarData() {
    }

    public CarData(Dta carDataDta, Drs drs, Integer trackStatus, Date dateTime, Integer time, Integer sessionTime, Short rpm, Short speed, Short nGear, Short throttle, Boolean isBraking, Float distance, Float differentialDistance, Float relativeDistance, Integer distanceDriverAhead) {
        this.carDataDta = carDataDta;
        this.drs = drs;
        this.trackStatus = trackStatus;
        this.dateTime = dateTime;
        this.time = time;
        this.sessionTime = sessionTime;
        this.rpm = rpm;
        this.speed = speed;
        this.nGear = nGear;
        this.throttle = throttle;
        this.isBraking = isBraking;
        this.distance = distance;
        this.differentialDistance = differentialDistance;
        this.relativeDistance = relativeDistance;
        this.distanceDriverAhead = distanceDriverAhead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dta getCarDataDta() {
        return carDataDta;
    }

    public void setCarDataDta(Dta carDataDta) {
        this.carDataDta = carDataDta;
    }

    public Drs getDrs() {
        return drs;
    }

    public void setDrs(Drs drs) {
        this.drs = drs;
    }

    public Integer getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(Integer trackStatus) {
        this.trackStatus = trackStatus;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Integer sessionTime) {
        this.sessionTime = sessionTime;
    }

    public Short getRpm() {
        return rpm;
    }

    public void setRpm(Short rpm) {
        this.rpm = rpm;
    }

    public Short getSpeed() {
        return speed;
    }

    public void setSpeed(Short speed) {
        this.speed = speed;
    }

    public Short getnGear() {
        return nGear;
    }

    public void setnGear(Short nGear) {
        this.nGear = nGear;
    }

    public Short getThrottle() {
        return throttle;
    }

    public void setThrottle(Short throttle) {
        this.throttle = throttle;
    }

    public Boolean getBraking() {
        return isBraking;
    }

    public void setBraking(Boolean braking) {
        isBraking = braking;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Float getDifferentialDistance() {
        return differentialDistance;
    }

    public void setDifferentialDistance(Float differentialDistance) {
        this.differentialDistance = differentialDistance;
    }

    public Float getRelativeDistance() {
        return relativeDistance;
    }

    public void setRelativeDistance(Float relativeDistance) {
        this.relativeDistance = relativeDistance;
    }

    public Integer getDistanceDriverAhead() {
        return distanceDriverAhead;
    }

    public void setDistanceDriverAhead(Integer distanceDriverAhead) {
        this.distanceDriverAhead = distanceDriverAhead;
    }
}
