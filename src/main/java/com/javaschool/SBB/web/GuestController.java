package com.javaschool.SBB.web;

import com.javaschool.SBB.db.DTO.SuitableRouteDTO;
import com.javaschool.SBB.db.DTO.TicketSearchDTO;
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

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
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
        List<SuitableRouteDTO> routes = ticketService.getSuitableRoutes(ticketSearchDTO);
        redirectAttributes.addFlashAttribute("routeList", routes);
        return "redirect:/showRoutes";
    }

    @RequestMapping(value = "/showRoutes", method = RequestMethod.GET)
    public String showSuitableTrains(@ModelAttribute(name = "routeList") List<SuitableRouteDTO> routeList,
                                     Model model) {
        model.addAttribute("routeList", routeList);
        model.addAttribute("selectedRoute", new SuitableRouteDTO());
        return "suitable_trains";
    }

    @RequestMapping(value = "/buyTicket/{trainName}", method= RequestMethod.POST)
    public String showRoutes(@ModelAttribute(name = "selectedRoute") SuitableRouteDTO selectedRoute ,
                             Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        boolean haveEmptySeats = ticketService.hasEmptySeats(selectedRoute);
        boolean moreThenTenMinutesBeforeDeparture = trainService.moreThenTenMinutesBeforeDeparture(selectedRoute);

        if(haveEmptySeats && moreThenTenMinutesBeforeDeparture) {
            session.setAttribute("selectedRoute", new SuitableRouteDTO());
            return "redirect:/confirmPage";
        }
        else if(!haveEmptySeats) {
            redirectAttributes.addFlashAttribute("message","The train is full  the route");
            return "redirect:/purchase_error";
        }
        else if(!moreThenTenMinutesBeforeDeparture) {
            redirectAttributes.addFlashAttribute("message", "Can not buy ticket for the train, that leaves in" +
                    "less then 10 minutes");
            return "redirect:/error_page";
        }
        else return "redirect:/error_page";

    }

    @RequestMapping(value = "/confirmPage", method = RequestMethod.GET)
    public String redirectToConfirmPage(@ModelAttribute(name = "selectedRoute") SuitableRouteDTO selectedRoute,
                                        Model model) {
        model.addAttribute("selectedRoute", selectedRoute);
        return "confirm_page";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String confirm(@ModelAttribute(name = "selectedRoute") SuitableRouteDTO selectedRoute){
        ticketService.addTicket(selectedRoute);
        return "redirect:/successful";
    }


}
