package com.kurios.f1_analysis.pos_data;

import com.kurios.f1_analysis.lap.Lap;
import com.kurios.f1_analysis.track_status.TrackStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PosData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pos_data_id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name= "lap_id")
    private Lap posData;

    @ManyToOne()
    @JoinColumn(name= "track_status_id")
    private TrackStatus trackStatus;

    private Date dateTime;

    private Integer time;

    private Integer sessionTime;

    private Short x;

    private Short y;

    private Short z;

    private Boolean carOnTrack;

    public PosData() {
    }

    public PosData(Lap posData, TrackStatus trackStatus, Date dateTime, Integer time, Integer sessionTime, Short x, Short y, Short z, Boolean carOnTrack) {
        this.posData = posData;
        this.trackStatus = trackStatus;
        this.dateTime = dateTime;
        this.time = time;
        this.sessionTime = sessionTime;
        this.x = x;
        this.y = y;
        this.z = z;
        this.carOnTrack = carOnTrack;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lap getPosData() {
        return posData;
    }

    public void setPosData(Lap posData) {
        this.posData = posData;
    }

    public TrackStatus getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(TrackStatus trackStatus) {
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

    public Short getX() {
        return x;
    }

    public void setX(Short x) {
        this.x = x;
    }

    public Short getY() {
        return y;
    }

    public void setY(Short y) {
        this.y = y;
    }

    public Short getZ() {
        return z;
    }

    public void setZ(Short z) {
        this.z = z;
    }

    public Boolean getCarOnTrack() {
        return carOnTrack;
    }

    public void setCarOnTrack(Boolean carOnTrack) {
        this.carOnTrack = carOnTrack;
    }
}
