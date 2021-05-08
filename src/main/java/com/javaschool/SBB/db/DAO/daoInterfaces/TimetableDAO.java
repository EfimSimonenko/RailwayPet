package com.javaschool.SBB.db.DAO.daoInterfaces;

import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Timetable;

import java.time.LocalDate;
import java.util.List;

public interface TimetableDAO {

    List getStationTimetableForToday(Station station);

    void addToTimetable(Timetable timetable);

    List<Timetable> getFullTimetable();



}
