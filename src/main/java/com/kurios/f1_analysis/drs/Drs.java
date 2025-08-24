package com.kurios.f1_analysis.drs;

import com.kurios.f1_analysis.car_data.CarData;
import jakarta.persistence.*;

import java.util.List;

@Entity

public class Drs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drs_data_id")
    private Integer id;

    @OneToMany(
            mappedBy = "drs",
            cascade = CascadeType.ALL
    )
    private List<CarData> drsList;

    @Column(length = 10)
    private String drs_state;

    public Drs() {
    }

    public Drs(Integer id, String drs_state) {
        this.id = id;
        this.drs_state = drs_state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrs_state() {
        return drs_state;
    }

    public void setDrs_state(String drs_state) {
        this.drs_state = drs_state;
    }
}
