package com.kurios.f1_analysis.team;

import com.kurios.f1_analysis.driver_team_assignment.DriverTeamAssignment;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "team_id")
    private Integer id;

    @Column(length = 30, unique = true)
    private String teamName;

    @Column(length = 7)
    private String teamHexColor;

    @OneToMany(
            mappedBy = "team",
            cascade = CascadeType.ALL
    )
    private List<DriverTeamAssignment> dtaList;

    public Team() {
    }

    public Team(String teamName, String teamHexColor) {
        this.teamName = teamName;
        this.teamHexColor = teamHexColor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamHexColor() {
        return teamHexColor;
    }

    public void setTeamHexColor(String teamHexColor) {
        this.teamHexColor = teamHexColor;
    }
}
