package com.javaschool.SBB.db.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "passenger")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn (name = "station_from")
    private Station stationFrom;

    @ManyToOne
    @JoinColumn (name = "station_to")
    private Station stationTo;

    public Ticket() {
    }

    public Ticket(Train train, Passenger passenger, Station stationFrom, Station stationTo) {
        this.train = train;
        this.passenger = passenger;
        this.stationFrom = stationFrom;
        this.stationTo = stationTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Passenger getUser() {
        return passenger;
    }

    public void setPasssenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Station getStationFrom() {
        return stationFrom;
    }

    public void setStationFrom(Station stationFrom) {
        this.stationFrom = stationFrom;
    }

    public Station getStationTo() {
        return stationTo;
    }

    public void setStationTo(Station stationTo) {
        this.stationTo = stationTo;
    }
}
