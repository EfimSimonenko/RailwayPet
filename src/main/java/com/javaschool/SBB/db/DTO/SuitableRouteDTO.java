package com.javaschool.SBB.db.DTO;

import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Train;

import java.time.LocalDateTime;

public class SuitableRouteDTO {

    private Train train;
    private Station departureStation;
    private Station arrivalStation;
    private String departureTime;
    private String arrivalTime;

    public SuitableRouteDTO() {
    }

    public SuitableRouteDTO(Train train, Station departureStation, Station arrivalStation, String departureTime, String arrivalTime) {
        this.train = train;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
