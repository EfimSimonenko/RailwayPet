package com.javaschool.SBB.db.DAO.DaoImpl;

import com.javaschool.SBB.db.DAO.daoInterfaces.PassengerDAO;
import com.javaschool.SBB.db.entities.Passenger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Repository
public class PassengerDAOImpl implements PassengerDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return null;
    }

    @Override
    public void createPassenger(Passenger passenger) {
        entityManager.persist(passenger);
    }

    @Override
    public Passenger findByNameAndDateOfBirth(String firstName, String lastName, Date dateOfBirth) {
        String queryString = "SELECT p FROM Passenger p WHERE p.firstName = :firstName " +
                "AND p.lastName = :lastName AND p.dateOfBirth = :dateOfBirth";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("dateOfBirth", dateOfBirth);
        return (Passenger) query.getSingleResult();
    }
    @Override
    public List<Passenger> findPassengersOnBoard(String trainName, Date tripDate){
        /*String queryString = "SOME JOIN STRING"
        Query query = entityManager.createQuery(queryString);
        query.setParameter("trainName", trainName);
        query.setParameter("tripDate", tripDate);
        List<Passenger> passengersOnBoard = (Passenger) query.getResultList();
         */
        return new ArrayList<>();
    }

    @Override
    public List<Passenger> findAll() {
        return null;
    }

    public Passenger findByLastName(String lastName) {
        Passenger passenger = entityManager.find(Passenger.class, lastName);
        return passenger;
    }
}
