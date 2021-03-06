package com.javaschool.SBB.web;

import com.javaschool.SBB.db.DTO.PassengerDTO;
import com.javaschool.SBB.db.DTO.SuitableRouteDTO;
import com.javaschool.SBB.db.DTO.TicketSearchDTO;
import com.javaschool.SBB.db.entities.Passenger;
import com.javaschool.SBB.service.TicketService;
import com.javaschool.SBB.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GuestController {

    @Autowired
    TicketService ticketService;

    @Autowired
    TrainService trainService;

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    ConnectionFactory connectionFactory;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getWelcomePage() {

        return "index";
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String findTicketPage(Model model) {
        model.addAttribute("ticketSearchForm", new TicketSearchDTO());


        try {
            JMSContext context = connectionFactory.createContext("sima", "Simasima11");
            context.createProducer().send(jmsTemplate.getDefaultDestination(), "Hi");
            context.close();
        } catch (Exception e) {
            System.out.println("smth wrong");
        }

        return "find_ticket";
    }

    @RequestMapping(value = "/searchForTrain", method = RequestMethod.POST)
    public String findTicket(@ModelAttribute TicketSearchDTO ticketSearchDTO, RedirectAttributes redirectAttributes) {
        List<SuitableRouteDTO> routeList = ticketService.getSuitableRoutes(ticketSearchDTO);
        if (routeList.size() == 0) {
            redirectAttributes.addFlashAttribute("message", "No trains were found");
            return "redirect:/purchaseError";
        }
        redirectAttributes.addFlashAttribute("routeList", routeList);
        return "redirect:/showRoutes";
    }

    @RequestMapping(value = "/showRoutes", method = RequestMethod.GET)
    public String showSuitableTrains(@ModelAttribute(name = "routeList") List<SuitableRouteDTO> routeList,
                                     Model model) {
        model.addAttribute("routeList", routeList);
        model.addAttribute("selectedRoute", new SuitableRouteDTO());
        return "suitable_trains";
    }

    @RequestMapping(value = "/buyTicket", method= RequestMethod.POST)
    public String showRoutes(@ModelAttribute(name = "selectedRoute") SuitableRouteDTO selectedRoute,
                             Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        //SuitableRouteDTO selectedRoute = (SuitableRouteDTO) session.getAttribute("route");

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
            redirectAttributes.addFlashAttribute("message", "Train has already left or leaves in less then 10 minutes." +
                    " Can not purchase.");
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
            return "redirect:/purchaseError";
        }
    }

    @RequestMapping(value = "/successful", method = RequestMethod.GET)
    public String getSuccessfulPage(){
        return "successful";
    }



}
