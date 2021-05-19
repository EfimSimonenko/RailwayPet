package com.javaschool.SBB.db.DTO;

import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Train;

public class TimetableDTO {
    private int id;
    private Train trainId;
    private Station stationId;
    private String arrivalTime;
    private String departureTime;

    public TimetableDTO() {
    }

    public TimetableDTO(Train trainId, Station stationId, String arrivalDate, String departureDate) {
        this.trainId = trainId;
        this.stationId = stationId;
        this.arrivalTime = arrivalDate;
        this.departureTime = departureDate;
    }



    public Train getTrainId() {
        return trainId;
    }

    public void setTrainId(Train trainId) {
        this.trainId = trainId;
    }

    public Station getStationId() {
        return stationId;
    }

    public void setStationId(Station stationId) {
        this.stationId = stationId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
