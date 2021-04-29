package com.javaschool.SBB.db.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "trainId")
    @OneToMany
    private List<Train> trainId;

    @Column(name = "stationId")
    @OneToMany
    private List<Station> stationId;

    @Column(name = "arrivalTime")
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;


}
