package com.kurios.f1_analysis.drs;

import com.kurios.f1_analysis.car_data.CarData;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "drs", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"drs_id", "drs_state" })
})
public class Drs {
    @Id
    @Column(name = "drs_id", unique=true)
    private Integer id;

    @OneToMany(
            mappedBy = "drs",
            cascade = CascadeType.ALL
    )
    private List<CarData> drsList;

    @Column(length = 10)
    private String drsState;

    public Drs() {
    }

    public Drs(Integer id, String drsState) {
        this.id = id;
        this.drsState = drsState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrsState() {
        return drsState;
    }

    public void setDrsState(String drsState) {
        this.drsState = drsState;
    }
}
