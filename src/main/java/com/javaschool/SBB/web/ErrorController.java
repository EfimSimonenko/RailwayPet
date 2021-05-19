package com.javaschool.SBB.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

    @RequestMapping(value = "/purchaseError", method = RequestMethod.GET)
    public String showPurchaseErrorPage(@ModelAttribute(name = "message") String errorMessage,
                                        Model model) {
        model.addAttribute("message", errorMessage);
        return "purchase_error";
    }

}
