package com.javaschool.SBB.service;

import com.javaschool.SBB.db.DAO.Mapper;
import com.javaschool.SBB.db.DAO.daoInterfaces.TimetableDAO;
import com.javaschool.SBB.db.DTO.TimetableDTO;
import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Timetable;
import com.javaschool.SBB.hepler.DateTimeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TimetableService {

    @Autowired
    TimetableDAO timetableDAO;

    @Autowired
    Mapper mapper;

    @Autowired
    DateTimeParser dateTimeParser;


    public List<TimetableDTO> getStationTimetableForToday(Station station) {
        List<Timetable> timetableByDate = timetableDAO.getStationTimetableForToday(station);
        List<TimetableDTO> timetableByDateDto = timetableByDate.stream().map(s -> mapper.entityToDto(s)).collect(Collectors.toList());
        return timetableByDateDto;
    }

    public List<TimetableDTO> getStationTimetableByDate(Station station, String stringDate) {
        LocalDate date = dateTimeParser.stringToLocalDate(stringDate);
        List<Timetable> timetableByDate = timetableDAO.getStationTimetableByDate(station, date);
        List<TimetableDTO> timetableByDateDto = timetableByDate.stream().map(s -> mapper.entityToDto(s)).collect(Collectors.toList());
        return timetableByDateDto;
    }

    public void addToTimetable(TimetableDTO timetableDTO) {

        Timetable timetable = mapper.dtoToEntity(timetableDTO);
        timetableDAO.addToTimetable(timetable);
    }

    public List<TimetableDTO> getFullTimetable() {
        List<Timetable> fullTimetable = timetableDAO.getFullTimetable();
        List<TimetableDTO> fullTimetableDto = fullTimetable.stream().map(s -> mapper.entityToDto(s)).collect(Collectors.toList());
        return fullTimetableDto;
    }


}
