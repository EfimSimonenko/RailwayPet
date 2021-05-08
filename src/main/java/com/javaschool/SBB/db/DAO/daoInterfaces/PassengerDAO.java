package com.javaschool.SBB.db.DAO.daoInterfaces;

import com.javaschool.SBB.db.entities.Passenger;
import com.javaschool.SBB.db.entities.Train;


import java.sql.Date;
import java.util.List;

public interface PassengerDAO{


    Passenger findByNameAndDateOfBirth(String firstName, String lastName, Date dateOfBirth);

    List<Passenger> findPassengersOnBoard(Train train);

    public void createPassenger(Passenger passenger);




}
