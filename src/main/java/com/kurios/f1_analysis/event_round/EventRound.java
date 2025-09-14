package com.kurios.f1_analysis.event_round;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kurios.f1_analysis.session.Session;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity()
@Table(name = "event_round", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"year", "round_number", "country", "location", "event_name", "event_date", "is_sprint_event", "soft", "medium", "hard"})
})
public class EventRound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "event_round_id", unique=true)
    private Integer id;

    @OneToMany(
            mappedBy = "eventRound",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Session> sessions;

    private Short year;

    private Short roundNumber;

    @Column(length = 30)
    private String country;

    @Column(length = 30)
    private String location;

    @Column(length = 100)
    private String eventName;

    @Column(unique = true)
    private Date eventDate;

    private Boolean isSprintEvent;

    private Short soft;

    private Short medium;

    private Short hard;

    public EventRound() {
    }

    public EventRound(Short year, Short roundNumber, String country, String location, String eventName, Date eventDate, Boolean isSprintEvent, Short soft, Short medium, Short hard) {
        this.year = year;
        this.roundNumber = roundNumber;
        this.country = country;
        this.location = location;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.isSprintEvent = isSprintEvent;
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

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
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
        return isSprintEvent;
    }

    public void setSprintEvent(Boolean sprintEvent) {
        isSprintEvent = sprintEvent;
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
