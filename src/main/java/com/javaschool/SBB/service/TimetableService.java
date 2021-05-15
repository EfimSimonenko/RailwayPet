package com.javaschool.SBB.service;

import com.javaschool.SBB.db.DAO.Mapper;
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

    @Autowired
    Mapper mapper;


    public List<Timetable> getStationTimetableForToday(Station station) {
        return timetableDAO.getStationTimetableForToday(station);
    }

    public void addToTimetable(TimetableDTO timetableDTO) {

        Timetable timetable = mapper.dtoToEntity(timetableDTO);
        timetableDAO.addToTimetable(timetable);
    }

    public List<Timetable> getFullTimetable() {
        return timetableDAO.getFullTimetable();
    }


}
