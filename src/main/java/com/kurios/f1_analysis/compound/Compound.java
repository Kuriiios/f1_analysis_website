package com.kurios.f1_analysis.compound;

import com.kurios.f1_analysis.lap.Lap;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Compound {
    @Id
    @Column(name="compound_id")
    private Integer id;

    @OneToMany(
            mappedBy = "compound",
            cascade = CascadeType.ALL
    )
    private List<Lap> laps;

    @Column(length = 15)
    private String compoundName;

    public Compound() {
    }

    public Compound(Integer id, String compoundName) {
        this.id = id;
        this.compoundName = compoundName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompoundName() {
        return compoundName;
    }

    public void setCompound_name(String compoundName) {
        this.compoundName = compoundName;
    }
}
