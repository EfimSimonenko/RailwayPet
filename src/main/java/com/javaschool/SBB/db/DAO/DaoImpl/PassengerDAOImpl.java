package com.javaschool.SBB.db.DAO.DaoImpl;

import com.javaschool.SBB.db.DAO.daoInterfaces.PassengerDAO;
import com.javaschool.SBB.db.entities.Passenger;
import com.javaschool.SBB.db.entities.Train;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public class PassengerDAOImpl implements PassengerDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void createPassenger(Passenger passenger) {
        try {
        sessionFactory.getCurrentSession().persist(passenger);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Passenger> findByNameAndDateOfBirth(String firstName, String lastName, LocalDate dateOfBirth) {
        String queryString = "SELECT p FROM Passenger p WHERE p.firstName = :firstName " +
                "AND p.lastName = :lastName AND p.dateOfBirth = :dateOfBirth";
        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("dateOfBirth", dateOfBirth);
        return query.getResultList();
    }
    @Override
    public List<Passenger> findPassengersOnBoard(Train train){
        String queryString = "Select p FROM Passenger p INNER JOIN Ticket t WHERE t.train = :train";
        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        query.setParameter("train", train);
        List<Passenger> passengersOnBoard = (List<Passenger>) query.getResultList();
        return new ArrayList<>();
    }


}
