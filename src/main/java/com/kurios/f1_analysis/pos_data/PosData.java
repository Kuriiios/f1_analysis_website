package com.kurios.f1_analysis.pos_data;

import com.kurios.f1_analysis.lap.Lap;
import com.kurios.f1_analysis.track_status.TrackStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "pos_data", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"lap_id", "track_status_id", "date_time", "time", "session_time", "x", "y", "z", "is_car_on_track"})
})
public class PosData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pos_data_id", unique=true)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name= "lap_id")
    private Lap posDataLap;

    @ManyToOne()
    @JoinColumn(name= "track_status_id")
    private TrackStatus trackStatus;

    private Date dateTime;

    private Integer time;

    private Integer sessionTime;

    private Short x;

    private Short y;

    private Short z;

    private Boolean isCarOnTrack;

    public PosData() {
    }

    public PosData(Lap posDataLap, TrackStatus trackStatus, Date dateTime, Integer time, Integer sessionTime, Short x, Short y, Short z, Boolean isCarOnTrack) {
        this.posDataLap = posDataLap;
        this.trackStatus = trackStatus;
        this.dateTime = dateTime;
        this.time = time;
        this.sessionTime = sessionTime;
        this.x = x;
        this.y = y;
        this.z = z;
        this.isCarOnTrack = isCarOnTrack;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lap getPosDataLap() {
        return posDataLap;
    }

    public void setPosDataLap(Lap posDataLap) {
        this.posDataLap = posDataLap;
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
        return isCarOnTrack;
    }

    public void setCarOnTrack(Boolean carOnTrack) {
        isCarOnTrack = carOnTrack;
    }
}
