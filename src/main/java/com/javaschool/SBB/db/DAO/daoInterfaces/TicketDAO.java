package com.javaschool.SBB.db.DAO.daoInterfaces;

import com.javaschool.SBB.db.entities.Ticket;
import com.javaschool.SBB.db.entities.Train;

import java.util.List;

public interface TicketDAO {

    void create(Ticket ticket);

    List<Ticket> getTicketsByTrain(Train train);

}
