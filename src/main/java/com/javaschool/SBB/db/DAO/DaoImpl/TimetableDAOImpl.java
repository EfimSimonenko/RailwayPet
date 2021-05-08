package com.javaschool.SBB.db.DAO.DaoImpl;

import com.javaschool.SBB.db.DAO.daoInterfaces.TimetableDAO;
import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Timetable;
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

    @Override
    public List getStationTimetableForToday(Station station) {
        String customQuery = "SELECT t FROM timetable t WHERE t.station.id = :id AND t.arrival_time >= :startOfTheDay" +
                " AND t.departure_time <= :endOfTheDay";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createNamedQuery(customQuery, Station.class);
        query.setParameter("id", station.getId());
        LocalDateTime startOfTheDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfTheDay = LocalDate.now().atStartOfDay().plusDays(1);
        query.setParameter("arrivalTime", startOfTheDay);
        query.setParameter("departureTime", endOfTheDay);
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





}
