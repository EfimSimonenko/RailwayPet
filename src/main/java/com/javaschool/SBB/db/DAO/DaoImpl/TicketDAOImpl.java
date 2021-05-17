package com.javaschool.SBB.db.DAO.DaoImpl;

import com.javaschool.SBB.db.DAO.daoInterfaces.TicketDAO;
import com.javaschool.SBB.db.DTO.SuitableRouteDTO;
import com.javaschool.SBB.db.entities.Passenger;
import com.javaschool.SBB.db.entities.Ticket;
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
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void persist(Ticket ticket) {
            sessionFactory.getCurrentSession().persist(ticket);

    }

    @Override
    public List<Ticket> getTicketsByTrain(Train train) {
        String customQuery = "SELECT t FROM Ticket t WHERE t.train = :train";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(customQuery);
        query.setParameter("train", train);
        return query.getResultList();

    }

    public boolean hasPassengerWithSameNameAndDateOfBirth(Passenger passenger, Train train) {
        String customQuery = "SELECT t FROM Ticket t WHERE t.train.trainName = :train AND t.passenger.firstName = :firstName " +
                "AND t.passenger.lastName =:lastName AND t.passenger.dateOfBirth =:dateOfBirth";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(customQuery);
        query.setParameter("firstName", passenger.getFirstName());
        query.setParameter("lastName", passenger.getLastName());
        query.setParameter("dateOfBirth", passenger.getDateOfBirth());
        query.setParameter("train", train.getTrainName());
        if( query.getResultList().size() == 0) return false;
        else return true;
    }

    public void addTicket(SuitableRouteDTO selectedRoute, Passenger passenger) {
        Ticket ticket = new Ticket(selectedRoute.getTrain(), passenger, selectedRoute.getDepartureStation(),
                selectedRoute.getArrivalStation());
        persist(ticket);
    }
}
