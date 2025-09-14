package com.kurios.f1_analysis.track_status;

import com.kurios.f1_analysis.car_data.CarData;
import com.kurios.f1_analysis.lap.Lap;
import com.kurios.f1_analysis.pos_data.PosData;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "track_status", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"track-state"})
})
public class TrackStatus {
    @Id
    @Column(name="track_status_id", unique=true)
    private Integer id;

    @OneToMany(
            mappedBy = "trackStatus",
            cascade = CascadeType.ALL
    )
    private List<CarData> carDataList;

    @OneToMany(
            mappedBy = "trackStatus",
            cascade = CascadeType.ALL
    )
    private List<PosData> posDataList;

    @OneToMany(
            mappedBy = "trackStatus",
            cascade = CascadeType.ALL
    )
    private List<Lap> lapList;

    @Column(length = 20)
    private String trackState;

    public TrackStatus() {
    }

    public TrackStatus(String trackState) {
        this.trackState = trackState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Lap> getLapList() {
        return lapList;
    }

    public void setLapList(List<Lap> lapList) {
        this.lapList = lapList;
    }

    public List<CarData> getCarDataList() {
        return carDataList;
    }

    public void setCarDataList(List<CarData> carDataList) {
        this.carDataList = carDataList;
    }

    public List<PosData> getPosDataList() {
        return posDataList;
    }

    public void setPosDataList(List<PosData> posDataList) {
        this.posDataList = posDataList;
    }

    public String getTrackState() {
        return trackState;
    }

    public void setTrackState(String trackState) {
        this.trackState = trackState;
    }
}
