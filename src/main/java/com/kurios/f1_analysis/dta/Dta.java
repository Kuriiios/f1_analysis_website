package com.kurios.f1_analysis.dta;

import com.kurios.f1_analysis.car_data.CarData;
import com.kurios.f1_analysis.driver.Driver;
import com.kurios.f1_analysis.lap.Lap;
import com.kurios.f1_analysis.event_session.EventSession;
import com.kurios.f1_analysis.pos_data.PosData;
import com.kurios.f1_analysis.team.Team;
import com.kurios.f1_analysis.team_radio.TeamRadio;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dta", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"event_session_id", "driver_id", "team_id"})
})
public class Dta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "dta_id", unique=true)
    private Integer id;

    @OneToMany(
            mappedBy = "carDataDta",
            cascade = CascadeType.ALL
    )
    private List<CarData> carDataList;

    @OneToMany(
            mappedBy = "posDataDta",
            cascade = CascadeType.ALL
    )
    private List<PosData> posDataList;

    @ManyToOne()
    @JoinColumn(name= "event_session_id")
    private EventSession eventSession;

    @ManyToOne()
    @JoinColumn(name= "driver_id")
    private Driver driver;

    @ManyToOne()
    @JoinColumn(name= "team_id")
    private Team team;

    @OneToMany(
            mappedBy = "dta",
            cascade = CascadeType.ALL
    )
    private List<Lap> laps;

    @OneToMany(
            mappedBy = "dta_team_radio",
            cascade = CascadeType.ALL
    )
    private List<TeamRadio> teamRadio;

    public Dta() {
    }

    public Dta(EventSession eventSession, Driver driver, Team team) {
        this.eventSession = eventSession;
        this.driver = driver;
        this.team = team;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EventSession getSession() {
        return eventSession;
    }

    public void setSession(EventSession eventSession) {
        this.eventSession = eventSession;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
