package com.javaschool.SBB.db.DAO.daoInterfaces;

import com.javaschool.SBB.db.entities.Passenger;


import java.sql.Date;
import java.util.List;

public interface PassengerDAO{

    Passenger savePassenger(Passenger passenger);

    void createPassenger(Passenger passenger) ;

    Passenger findByNameAndDateOfBirth(String firstName, String lastName, Date dateOfBirth);

    List<Passenger> findPassengersOnBoard(String trainName, Date tripDate);

    List findAll();
}
