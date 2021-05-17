package com.javaschool.SBB.db.entities;

import javax.persistence.*;


@Entity
@Table(name = "train")
public class Train {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "train_name", unique = true)
    private String trainName;

    @Column(name = "number_of_seats", nullable = false)
    private int numberOfSeats;


    public Train() {
    }

    public Train(String trainName, int numberOfSeats) {
        this.trainName = trainName;
        this.numberOfSeats = numberOfSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString(){
        return "" + this.getTrainName();
    }
}
