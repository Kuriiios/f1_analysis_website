package com.kurios.f1_analysis.session;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kurios.f1_analysis.driver_team_assignment.DriverTeamAssignment;
import com.kurios.f1_analysis.event_round.EventRound;
import com.kurios.f1_analysis.weather.Weather;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="session_id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name= "event_round_id")
    @JsonBackReference
    private EventRound eventRound;

    @Column(length=20)
    private String sessionName;

    private Date sessionDate;

    @OneToMany(
            mappedBy = "weather",
            cascade = CascadeType.ALL
    )
    private List<Weather> weatherList;

    @OneToMany(
            mappedBy = "session",
            cascade = CascadeType.ALL
    )
    private List<DriverTeamAssignment> dtaList;

    public Session() {
    }

    public Session(EventRound eventRound, String sessionName, Date sessionDate) {
        this.eventRound = eventRound;
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EventRound getEventRound() {
        return eventRound;
    }

    public void setEventRound(EventRound eventRound) {
        this.eventRound = eventRound;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

}
