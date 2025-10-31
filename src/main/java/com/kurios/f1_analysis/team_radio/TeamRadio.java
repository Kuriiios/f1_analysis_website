package com.kurios.f1_analysis.team_radio;

import com.kurios.f1_analysis.dta.Dta;
import com.kurios.f1_analysis.event_session.EventSession;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "team_radio", uniqueConstraints = {})
public class TeamRadio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_radio_id", unique = true)
    private Integer teamRadioId;

    @ManyToOne()
    @JoinColumn(name= "dta_id")
    private Dta dta_team_radio;

    private Date dateTime;

    private String teamRadioMessage;

    private String teamRadioUrl;

    public TeamRadio(Date dateTime, String teamRadioMessage, String teamRadioUrl, Dta dta_team_radio) {
        this.dateTime = dateTime;
        this.teamRadioMessage = teamRadioMessage;
        this.teamRadioUrl = teamRadioUrl;
        this.dta_team_radio = dta_team_radio;
    }

    public TeamRadio() {
    }

    public Integer getTeamRadioId() {
        return teamRadioId;
    }

    public void setTeamRadioId(Integer teamRadioId) {
        this.teamRadioId = teamRadioId;
    }

    public Dta getDta_team_radio() {
        return dta_team_radio;
    }

    public void setDta_team_radio(Dta dta_team_radio) {
        this.dta_team_radio = dta_team_radio;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getTeamRadioMessage() {
        return teamRadioMessage;
    }

    public void setTeamRadioMessage(String teamRadioMessage) {
        this.teamRadioMessage = teamRadioMessage;
    }

    public String getTeamRadioUrl() {
        return teamRadioUrl;
    }

    public void setTeamRadioUrl(String teamRadioUrl) {
        this.teamRadioUrl = teamRadioUrl;
    }
}
