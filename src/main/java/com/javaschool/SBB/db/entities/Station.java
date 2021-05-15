package com.javaschool.SBB.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "station")
public class Station {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "station_name", unique = true, nullable = false)
    private String stationName;

    public Station() {
    }

    public Station(String stationName) {
        this.stationName = stationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String toString() {
        return "" + this.getStationName();
    }
}
