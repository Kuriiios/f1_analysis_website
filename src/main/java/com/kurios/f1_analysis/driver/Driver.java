package com.kurios.f1_analysis.driver;

import com.kurios.f1_analysis.dta.Dta;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "driver", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"driver_number", "driver_abbreviation", "driver_name", "driver_hex_color", "country"})
})
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id", unique=true)
    private Integer id;

    @OneToMany(
            mappedBy = "driver",
            cascade = CascadeType.ALL
    )
    private List<Dta> dtaList;

    private Short driverNumber;

    @Column(length = 3)
    private String driverAbbreviation;

    @Column(length = 40)
    private String driverName;

    @Column(length = 7)
    private String driverHexColor;

    @Column(length = 2)
    private String country;

    public Driver() {
    }

    public Driver(Short driverNumber, String driverAbbreviation, String driverName, String driverHexColor, String country) {
        this.driverNumber = driverNumber;
        this.driverAbbreviation = driverAbbreviation;
        this.driverName = driverName;
        this.driverHexColor = driverHexColor;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(Short driverNumber) {
        this.driverNumber = driverNumber;
    }

    public String getDriverAbbreviation() {
        return driverAbbreviation;
    }

    public void setDriverAbbreviation(String driverAbbreviation) {
        this.driverAbbreviation = driverAbbreviation;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDriverHexColor() {
        return driverHexColor;
    }

    public void setDriverHexColor(String driverHexColor) {
        this.driverHexColor = driverHexColor;
    }
}
