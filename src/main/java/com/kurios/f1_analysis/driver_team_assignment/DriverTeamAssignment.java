package com.kurios.f1_analysis.driver_team_assignment;

import com.kurios.f1_analysis.driver.Driver;
import com.kurios.f1_analysis.lap.Lap;
import com.kurios.f1_analysis.session.Session;
import com.kurios.f1_analysis.team.Team;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dta", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"session_id", "driver_id", "team_id"})
})
public class DriverTeamAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "dta_id", unique=true)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name= "session_id")
    private Session session;

    @ManyToOne()
    @JoinColumn(name= "driver_id")
    private Driver driver;

    @ManyToOne()
    @JoinColumn(name= "team_id")
    private Team team;

    @OneToMany(
            mappedBy = "driverTeamAssignment",
            cascade = CascadeType.ALL
    )
    private List<Lap> laps;

    public DriverTeamAssignment() {
    }

    public DriverTeamAssignment(Session session, Driver driver, Team team) {
        this.session = session;
        this.driver = driver;
        this.team = team;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
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
