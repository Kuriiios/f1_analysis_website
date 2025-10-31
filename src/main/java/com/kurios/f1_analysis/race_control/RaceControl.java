package com.kurios.f1_analysis.race_control;

import com.kurios.f1_analysis.event_session.EventSession;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "race_control", uniqueConstraints = {})
public class RaceControl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "race_control_id", unique = true)
    private Integer raceControlId;

    @OneToMany(
            mappedBy = "raceControl",
            cascade = CascadeType.ALL
    )
    private List<EventSession> eventSessions;

    private Date dateTime;

    private String raceControlMessage;

    public RaceControl(Date dateTime, String raceControlMessage) {
        this.dateTime = dateTime;
        this.raceControlMessage = raceControlMessage;
    }

    public RaceControl() {
    }

    public Integer getRaceControlId() {
        return raceControlId;
    }

    public void setRaceControlId(Integer raceControlId) {
        this.raceControlId = raceControlId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getRaceControlMessage() {
        return raceControlMessage;
    }

    public void setRaceControlMessage(String raceControlMessage) {
        this.raceControlMessage = raceControlMessage;
    }
}
