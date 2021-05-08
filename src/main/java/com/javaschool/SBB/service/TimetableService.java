package com.javaschool.SBB.service;

import com.javaschool.SBB.db.DAO.daoInterfaces.TimetableDAO;
import com.javaschool.SBB.db.DTO.TimetableDTO;
import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class TimetableService {

    @Autowired
    TimetableDAO timetableDAO;



    public List<Timetable> getStationTimetableForToday(Station station) {
        return timetableDAO.getStationTimetableForToday(station);
    }

    public void addToTimetable(TimetableDTO timetableDTO) {
        Timetable timetable = dtoToEntity(timetableDTO);
        timetableDAO.addToTimetable(timetable);
    }

    public List<Timetable> getFullTimetable() {
        return timetableDAO.getFullTimetable();
    }

    public Timetable dtoToEntity(TimetableDTO timetableDTO) {
        LocalDateTime arrivalTime = LocalDateTime.parse(timetableDTO.getArrivalTime(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime departureTime = LocalDateTime.parse(timetableDTO.getDepartureTime(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return new Timetable(timetableDTO.getTrainId(), timetableDTO.getStationId(), arrivalTime, departureTime);
    }
}
