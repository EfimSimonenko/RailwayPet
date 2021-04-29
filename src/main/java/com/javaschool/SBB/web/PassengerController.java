package com.javaschool.SBB.web;

import com.javaschool.SBB.db.DAO.DaoImpl.PassengerDAOImpl;
import com.javaschool.SBB.db.entities.Passenger;
import com.javaschool.SBB.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @Autowired
    PassengerDAOImpl passengerDAO;


    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(Model model) {
        return "passenger";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createPassenger(Passenger passenger) {
        this.passengerService.createPassenger(passenger);
        return "redirect:/passenger/" + passenger.getLastName();
    }

    @RequestMapping(value = "/passenger/{lastName}", method = RequestMethod.GET)
    public String showRegisteredPassenger(@PathVariable String lastName, Model model) {
        Passenger passenger = passengerDAO.findByLastName(lastName);
        model.addAttribute(passenger);
        return "profile";
    }

}
