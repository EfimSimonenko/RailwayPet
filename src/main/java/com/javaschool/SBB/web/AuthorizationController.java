package com.javaschool.SBB.web;

import com.javaschool.SBB.db.DTO.RegistrationDTO;
import com.javaschool.SBB.db.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorizationController {

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("registrationForm", new RegistrationDTO());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registrationProcessor(@ModelAttribute(name = "registrationForm") User user, Model model) {
        return "findTicket";
    }


}
