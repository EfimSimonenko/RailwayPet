package com.javaschool.SBB.db.DAO.DaoImpl;

import com.javaschool.SBB.db.DAO.daoInterfaces.TrainDAO;
import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Train;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TrainDAOImpl implements TrainDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(Train train) {
        this.sessionFactory.getCurrentSession().persist(train);
    }

    @Override
    public Train findById(int id) {
        Train train = sessionFactory.getCurrentSession().load(Train.class, new Integer(id));
        return train;
    }

    public List<Train> getAllTrains() {
        Session session = sessionFactory.getCurrentSession();
        List<Train> stationList = session.createQuery("from Train").list();
        return stationList;
    }

    @Override
    public Train getByName(String trainName) {
        String namedQuery = "SELECT t FROM Train t WHERE t.trainName = :trainName";

        Query query = sessionFactory.getCurrentSession().createQuery(namedQuery);
        query.setParameter("trainName", trainName);
        return (Train) query.getSingleResult();
    }



}
