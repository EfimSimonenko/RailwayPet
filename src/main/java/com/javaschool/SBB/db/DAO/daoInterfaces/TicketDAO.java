package com.javaschool.SBB.db.DAO.daoInterfaces;

import com.javaschool.SBB.db.DTO.SuitableRouteDTO;
import com.javaschool.SBB.db.entities.Passenger;
import com.javaschool.SBB.db.entities.Ticket;
import com.javaschool.SBB.db.entities.Train;

import java.util.List;

public interface TicketDAO {

    void persist(Ticket ticket);

    List<Ticket> getTicketsByTrain(Train train);

    boolean hasPassengerWithSameNameAndDateOfBirth(Passenger passenger, Train train);

    void addTicket(SuitableRouteDTO selectedRoute, Passenger passenger);

}
