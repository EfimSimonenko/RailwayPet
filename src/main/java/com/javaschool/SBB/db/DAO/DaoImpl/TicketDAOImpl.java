package com.javaschool.SBB.db.DAO.DaoImpl;

import com.javaschool.SBB.db.DAO.daoInterfaces.TicketDAO;
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
    public void create(Ticket ticket) {

    }

    @Override
    public List<Ticket> getTicketsByTrain(Train train) {
        String customQuery = "SELECT t FROM Ticket t WHERE t.train = :train";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(customQuery);
        query.setParameter("train", train);
        return query.getResultList();

    }
}
