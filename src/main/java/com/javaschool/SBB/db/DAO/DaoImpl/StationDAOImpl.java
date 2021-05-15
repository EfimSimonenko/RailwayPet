package com.javaschool.SBB.db.DAO.DaoImpl;

import com.javaschool.SBB.db.DAO.daoInterfaces.StationDAO;
import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Timetable;
import com.javaschool.SBB.db.entities.Train;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StationDAOImpl implements StationDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createStation(Station station) {
            this.sessionFactory.getCurrentSession().persist(station);
    }
    @Override
    public List<Station> listAllStations() {
            Session session = sessionFactory.getCurrentSession();
            List<Station> stationList = session.createQuery("from Station").list();
            return stationList;
    }

    @Override
    public Station getStationById(int id) {
        Station station = sessionFactory.getCurrentSession().get(Station.class, new Integer(id));
        return station;
    }


    @Override
    public Station findByName(String stationName) {
        String namedQuery = "SELECT s FROM Station s WHERE s.stationName = :stationName";

        Query query = sessionFactory.getCurrentSession().createQuery(namedQuery);
        query.setParameter("stationName", stationName);
        return (Station) query.getSingleResult();
    }

}
