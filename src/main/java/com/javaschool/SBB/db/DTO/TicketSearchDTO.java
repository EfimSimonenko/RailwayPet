package com.javaschool.SBB.db.DTO;

public class TicketSearchDTO {
    private String stationFrom;
    private String departureTimeAfter;
    private String stationTo;
    private String arrivalTimeBefore;

    public TicketSearchDTO() {
    }

    public TicketSearchDTO(String stationFrom, String departureTimeAfter, String stationTo, String arrivalTimeBefore) {
        this.stationFrom = stationFrom;
        this.departureTimeAfter = departureTimeAfter;
        this.stationTo = stationTo;
        this.arrivalTimeBefore = arrivalTimeBefore;
    }

    public String getStationFrom() {
        return stationFrom;
    }

    public void setStationFrom(String stationFrom) {
        this.stationFrom = stationFrom;
    }

    public String getDepartureTimeAfter() {
        return departureTimeAfter;
    }

    public void setDepartureTimeAfter(String departureTimeAfter) {
        this.departureTimeAfter = departureTimeAfter;
    }

    public String getStationTo() {
        return stationTo;
    }

    public void setStationTo(String stationTo) {
        this.stationTo = stationTo;
    }

    public String getArrivalTimeBefore() {
        return arrivalTimeBefore;
    }

    public void setArrivalTimeBefore(String arrivalTimeBefore) {
        this.arrivalTimeBefore = arrivalTimeBefore;
    }
}
