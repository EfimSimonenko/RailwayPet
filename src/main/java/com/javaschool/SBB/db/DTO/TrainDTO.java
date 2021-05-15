package com.javaschool.SBB.db.DTO;

import javax.persistence.*;

public class TrainDTO {

        private int id;

        private String trainName;

        private int numberOfSeats;

    public TrainDTO() {
    }

    public TrainDTO(int id, String trainName, int numberOfSeats) {
        this.id = id;
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
}
