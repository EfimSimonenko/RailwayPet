package com.javaschool.SBB.db.DAO.daoInterfaces;

import com.javaschool.SBB.db.DTO.SuitableRouteDTO;
import com.javaschool.SBB.db.DTO.TicketSearchDTO;
import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Timetable;

import java.time.LocalDate;
import java.util.List;

public interface TimetableDAO {

    List getStationTimetableForToday(Station station);

    void addToTimetable(Timetable timetable);

    List<Timetable> getFullTimetable();

    List<Timetable> getTrainsOnDepartureStation(TicketSearchDTO requestedData);

    List<Timetable> getTrainsOnArrivalStation(TicketSearchDTO requstedData);

    List<Station> getTrainRoute(SuitableRouteDTO route);

    List<Timetable> getStationTimetableByDate(Station station, LocalDate date);




}
