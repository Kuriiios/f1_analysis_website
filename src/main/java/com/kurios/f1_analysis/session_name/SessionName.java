package com.kurios.f1_analysis.session_name;

import com.kurios.f1_analysis.event_session.EventSession;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "session_name", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"sessionName"})
})
public class SessionName {
    @Id
    @Column(name="session_name_id", unique=true)
    private Integer id;

    @OneToMany(
            mappedBy = "sessionName",
            cascade = CascadeType.ALL
    )
    private List<EventSession> eventSession;

    @Column(length = 25)
    private String sessionName;

    public SessionName() {
    }

    public SessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
