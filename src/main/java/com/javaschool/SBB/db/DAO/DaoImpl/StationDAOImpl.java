package com.javaschool.SBB.db.DAO.DaoImpl;

import com.javaschool.SBB.db.DAO.daoInterfaces.StationDAO;
import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Timetable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        Station station = sessionFactory.getCurrentSession().load(Station.class, new Integer(id));
        return station;
    }

}
