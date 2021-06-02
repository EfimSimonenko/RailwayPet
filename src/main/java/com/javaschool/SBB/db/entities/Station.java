package com.javaschool.SBB.db.entities;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.stationName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Station other = (Station) obj;
        if (this.stationName.compareTo(other.stationName)==0 ) {
            return true;
        }
        return false;
    }

}
