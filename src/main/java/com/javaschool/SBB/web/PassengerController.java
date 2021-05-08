package com.javaschool.SBB.web;

import com.javaschool.SBB.db.DAO.DaoImpl.PassengerDAOImpl;
import com.javaschool.SBB.db.DAO.daoInterfaces.PassengerDAO;
import com.javaschool.SBB.db.entities.Passenger;
import com.javaschool.SBB.db.entities.User;
import com.javaschool.SBB.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @Autowired
    PassengerDAO passengerDAO;


}
