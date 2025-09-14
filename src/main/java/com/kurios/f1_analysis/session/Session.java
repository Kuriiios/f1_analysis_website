package com.kurios.f1_analysis.session;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kurios.f1_analysis.driver_team_assignment.DriverTeamAssignment;
import com.kurios.f1_analysis.event_round.EventRound;
import com.kurios.f1_analysis.session_name.SessionName;
import com.kurios.f1_analysis.weather.Weather;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "session", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"event_round_id", "session_date", "session_name"})
})
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="session_id", unique=true)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name= "event_round_id")
    @JsonBackReference
    private EventRound eventRound;

    @ManyToOne()
    @JoinColumn(name= "session_name_id")
    @JsonBackReference
    private SessionName sessionName;

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

    public Session(EventRound eventRound, Date sessionDate, SessionName sessionName) {
        this.eventRound = eventRound;
        this.sessionDate = sessionDate;
        this.sessionName = sessionName;
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

    public SessionName getSessionName() {
        return sessionName;
    }

    public void setSessionName(SessionName sessionName) {
        this.sessionName = sessionName;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

}
