package com.javaschool.SBB.db.entities;


import javax.persistence.*;


public class Ticket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "trainId")
    private int trainId;

    @Column (name = "userId")
    private int userId;

    @Column (name = "stationFrom")
    @ManyToOne
    @JoinColumn (name = "stationId")
    private Station stationFrom;

    @Column (name = "stationTo")
    @ManyToOne
    @JoinColumn (name = "stationId")
    private Station stationTo;

}
