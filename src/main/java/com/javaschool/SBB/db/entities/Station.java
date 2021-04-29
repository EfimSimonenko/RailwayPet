package com.javaschool.SBB.db.entities;

import javax.persistence.*;

@Entity
public class Station {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "stationName")
    private String stationName;


}
