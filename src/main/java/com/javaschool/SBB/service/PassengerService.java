package com.javaschool.SBB.service;

import com.javaschool.SBB.db.DAO.DaoImpl.PassengerDAOImpl;
import com.javaschool.SBB.db.DAO.daoInterfaces.PassengerDAO;
import com.javaschool.SBB.db.entities.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PassengerService {

    @Autowired
    PassengerDAO passengerDAO;

    public void createPassenger(Passenger passenger){
        passengerDAO.createPassenger(passenger);
    }






}
