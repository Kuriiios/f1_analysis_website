package com.kurios.f1_analysis.track_status;

import com.kurios.f1_analysis.car_data.CarData;
import com.kurios.f1_analysis.lap.Lap;
import com.kurios.f1_analysis.pos_data.PosData;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TrackStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="track_status_data_id")
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
    private String track_state;

    public TrackStatus() {
    }

    public TrackStatus(List<Lap> lapList, String track_state) {
        this.lapList = lapList;
        this.track_state = track_state;
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

    public String getTrack_state() {
        return track_state;
    }

    public void setTrack_state(String track_state) {
        this.track_state = track_state;
    }
}
