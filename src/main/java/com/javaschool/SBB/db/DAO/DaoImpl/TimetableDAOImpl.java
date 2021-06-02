package com.javaschool.SBB.db.DAO.DaoImpl;

import com.javaschool.SBB.db.DAO.daoInterfaces.StationDAO;
import com.javaschool.SBB.db.DAO.daoInterfaces.TimetableDAO;
import com.javaschool.SBB.db.DTO.SuitableRouteDTO;
import com.javaschool.SBB.db.DTO.TicketSearchDTO;
import com.javaschool.SBB.db.DTO.TimetableDTO;
import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Timetable;
import com.javaschool.SBB.hepler.DateTimeParser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TimetableDAOImpl implements TimetableDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    StationDAO stationDAO;

    @Autowired
    DateTimeParser parser;

    @Override
    public List<Timetable> getStationTimetableForToday(Station station) {
        String customQuery = "SELECT t FROM Timetable t WHERE t.stationId = :station AND ((t.arrivalTime >= :startOfTheDay " +
                "AND t.arrivalTime <= :endOfTheDay) OR (t.departureTime <= :endOfTheDay AND t.departureTime >= :startOfTheDay))";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(customQuery);
        query.setParameter("station", station);
        LocalDateTime startOfTheDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfTheDay = LocalDate.now().atStartOfDay().plusDays(1);
        query.setParameter("startOfTheDay", startOfTheDay);
        query.setParameter("endOfTheDay", endOfTheDay);
        return query.getResultList();
    }


    public List<Timetable> getStationTimetableByDate(Station station, LocalDate date) {
        String customQuery = "SELECT t FROM Timetable t WHERE t.stationId = :station AND ((t.arrivalTime >= :startOfTheDay " +
                "AND t.arrivalTime <= :endOfTheDay) OR (t.departureTime <= :endOfTheDay AND t.departureTime >= :startOfTheDay))";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(customQuery);
        query.setParameter("station", station);
        LocalDateTime startOfTheDay = date.atStartOfDay();
        LocalDateTime endOfTheDay = date.atStartOfDay().plusDays(1);
        query.setParameter("startOfTheDay", startOfTheDay);
        query.setParameter("endOfTheDay", endOfTheDay);
        return query.getResultList();
    }

    @Override
    public void addToTimetable(Timetable timetable) {
        this.sessionFactory.getCurrentSession().persist(timetable);
    }

    public List<Timetable> getFullTimetable() {
        Session session = sessionFactory.getCurrentSession();
        List<Timetable> fullTimetable = session.createQuery("from Timetable").list();
        return fullTimetable;
    }

    @Override
    public List<Timetable> getTrainsOnDepartureStation(TicketSearchDTO requestedData) {
        String customQuery = "SELECT t FROM Timetable t WHERE t.stationId = :station" +
                " AND t.departureTime >= :departureTimeAfter";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(customQuery);
        query.setParameter("station", stationDAO.findByName(requestedData.getStationFrom()));
        query.setParameter("departureTimeAfter", parser.stringToLocalDateTime(requestedData.getDepartureTimeAfter()));
        return query.getResultList();
    }

    @Override
    public List<Timetable> getTrainsOnArrivalStation(TicketSearchDTO requestedData) {
        String customQuery = "SELECT t FROM Timetable t WHERE t.stationId = :station" +
                " AND t.arrivalTime <= :arrivalTimeBefore";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(customQuery);
        query.setParameter("station", stationDAO.findByName(requestedData.getStationTo()));
        query.setParameter("arrivalTimeBefore", parser.stringToLocalDateTime(requestedData.getArrivalTimeBefore()));
        return query.getResultList();
    }

    public List<Station> getTrainRoute(SuitableRouteDTO route) {
        String customQuery = "SELECT t.stationId FROM Timetable t WHERE t.trainId =:train" +
                " ORDER BY t.departureTime";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(customQuery);
        query.setParameter("train", route.getTrain());
        List trainStationList =  query.getResultList();
        return trainStationList;
    }






}
