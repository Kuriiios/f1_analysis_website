package com.kurios.f1_analysis.event_round;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kurios.f1_analysis.sessions.Sessions;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity()
public class EventRound {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "event_round_id")
    private Integer id;

    @OneToMany(
            mappedBy = "eventRound",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Sessions> sessions;

    private Short year;

    private Short roundNumber;

    @Column(length = 30)
    private String country;

    @Column(length = 30)
    private String location;

    @Column(length = 50)
    private String eventName;

    @Column(unique = true)
    private Date eventDate;

    private Boolean sprintEvent;

    private Short soft;

    private Short medium;

    private Short hard;

    public EventRound() {
    }

    public EventRound(Short year, Short roundNumber, String country, String location, String eventName, Date eventDate, Boolean sprintEvent, Short soft, Short medium, Short hard) {
        this.year = year;
        this.roundNumber = roundNumber;
        this.country = country;
        this.location = location;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.sprintEvent = sprintEvent;
        this.soft = soft;
        this.medium = medium;
        this.hard = hard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Sessions> getSessions() {
        return sessions;
    }

    public void setSessions(List<Sessions> sessions) {
        this.sessions = sessions;
    }

    public Integer getEventRoundId() {
        return id;
    }

    public void setEventRoundId(Integer eventRoundId) {
        this.id = eventRoundId;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public Short getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Short roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Boolean getSprintEvent() {
        return sprintEvent;
    }

    public void setSprintEvent(Boolean sprintEvent) {
        this.sprintEvent = sprintEvent;
    }

    public Short getSoft() {
        return soft;
    }

    public void setSoft(Short soft) {
        this.soft = soft;
    }

    public Short getMedium() {
        return medium;
    }

    public void setMedium(Short medium) {
        this.medium = medium;
    }

    public Short getHard() {
        return hard;
    }

    public void setHard(Short hard) {
        this.hard = hard;
    }
}
