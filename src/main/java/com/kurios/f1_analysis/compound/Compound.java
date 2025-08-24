package com.kurios.f1_analysis.compound;

import com.kurios.f1_analysis.lap.Lap;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Compound {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="compound_id")
    private Integer id;

    @OneToMany(
            mappedBy = "compound",
            cascade = CascadeType.ALL
    )
    private List<Lap> laps;

    @Column(length = 15)
    private String compound_name;

    public Compound() {
    }

    public Compound(String compound_name) {
        this.compound_name = compound_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompound_name() {
        return compound_name;
    }

    public void setCompound_name(String compound_name) {
        this.compound_name = compound_name;
    }
}
