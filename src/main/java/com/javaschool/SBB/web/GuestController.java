package com.javaschool.SBB.web;

import com.javaschool.SBB.db.DTO.PassengerDTO;
import com.javaschool.SBB.db.DTO.SuitableRouteDTO;
import com.javaschool.SBB.db.DTO.TicketSearchDTO;
import com.javaschool.SBB.db.entities.Passenger;
import com.javaschool.SBB.service.TicketService;
import com.javaschool.SBB.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GuestController {

    @Autowired
    TicketService ticketService;

    @Autowired
    TrainService trainService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getWelcomePage() {
        return "index";
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String findTicketPage(Model model) {
        model.addAttribute("ticketSearchForm", new TicketSearchDTO());
        return "find_ticket";
    }

    @RequestMapping(value = "/searchForTrain", method = RequestMethod.POST)
    public String findTicket(@ModelAttribute TicketSearchDTO ticketSearchDTO, RedirectAttributes redirectAttributes) {
        SuitableRouteDTO route = ticketService.getSuitableRoutes(ticketSearchDTO);
        redirectAttributes.addFlashAttribute("route", route);
        return "redirect:/showRoutes";
    }

    @RequestMapping(value = "/showRoutes", method = RequestMethod.GET)
    public String showSuitableTrains(@ModelAttribute(name = "route") SuitableRouteDTO route,
                                     Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        model.addAttribute("route", route);
        redirectAttributes.addFlashAttribute("route", route);
        session.setAttribute("route", route);
        return "suitable_trains";
    }

    @RequestMapping(value = "/buyTicket/{trainName}", method= RequestMethod.POST)
    public String showRoutes(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        SuitableRouteDTO selectedRoute = (SuitableRouteDTO) session.getAttribute("route");
        boolean hasEmptySeats = ticketService.hasEmptySeats(selectedRoute);
        boolean moreThenTenMinutesBeforeDeparture = trainService.moreThenTenMinutesBeforeDeparture(selectedRoute);

        if(hasEmptySeats && moreThenTenMinutesBeforeDeparture) {
            session.setAttribute("selectedRoute", selectedRoute);
            return "redirect:/confirmPage";
        }
        else if(!hasEmptySeats) {
            redirectAttributes.addFlashAttribute("message","Can not purchase. All seats are taken.");
            return "redirect:/purchaseError";
        }
        else if(!moreThenTenMinutesBeforeDeparture) {
            redirectAttributes.addFlashAttribute("message", "Can not buy a ticket for the train, that leaves in" +
                    "less then 10 minutes");
            return "redirect:/purchaseError";
        } else return "error";

    }

    @RequestMapping(value = "/confirmPage", method = RequestMethod.GET)
    public String redirectToConfirmPage(HttpSession session, Model model) {
        model.addAttribute("selectedRoute",session.getAttribute("selectedRoute"));
        model.addAttribute("passenger", new PassengerDTO());
        return "confirm_page";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String confirm(@ModelAttribute(name = "passenger") PassengerDTO passenger,
                          HttpSession session, RedirectAttributes redirectAttributes){
        SuitableRouteDTO selectedRoute = (SuitableRouteDTO) session.getAttribute("selectedRoute");
        if (!ticketService.hasPassengerWithSameNameAndDateOfBirth(passenger, selectedRoute.getTrain())) {
            ticketService.addTicket(selectedRoute, passenger);
            return "redirect:/successful";
        } else {
            redirectAttributes.addFlashAttribute("message", "Passenger with the same name and date of" +
                    "birth was already registered on this train");
            return "redirect:/error";
        }
    }

    @RequestMapping(value = "/successful", method = RequestMethod.GET)
    public String getSuccessfulPage(){
        return "successful";
    }


}
