package com.javaschool.SBB.db.entities;

import javax.persistence.*;


public class Train {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "trainName")
    private String trainName;

    @Column(name = "numberOfSeats")
    private int numberOfSeats;


}
