package com.javaschool.SBB.web;

import com.javaschool.SBB.db.DTO.TimetableDTO;
import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Timetable;
import com.javaschool.SBB.db.entities.Train;
import com.javaschool.SBB.service.StationService;
import com.javaschool.SBB.service.TimetableService;
import com.javaschool.SBB.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.stream.Collectors;

@Controller
public class AdminController {

    @Autowired
    TrainService trainService;

    @Autowired
    StationService stationService;

    @Autowired
    TimetableService timetableService;

    @RequestMapping(value = "/editTimetable", method = RequestMethod.GET)
    public String showTimetableEditor(Model model) {
        model.addAttribute("train", new Train());
        model.addAttribute("trainList", trainService.getAllTrains());
        model.addAttribute("station", new Station());
        model.addAttribute("stationList", stationService.listAllStations());
        model.addAttribute("timetable", new Timetable());
        model.addAttribute("fullTimetable", timetableService.getFullTimetable());
        model.addAttribute("trainStop", new TimetableDTO());
        return "manage_railway";
    }

    @RequestMapping(value = "/addTrain", method = RequestMethod.POST)
    public String addTrain(@ModelAttribute(name = "train") Train train, Model model) {
        trainService.createTrain(train);
        return "redirect: /editTimetable";
    }

    @RequestMapping(value = "/addStation", method = RequestMethod.POST)
    public String addStation(@ModelAttribute(name = "station") Station station) {
        stationService.createStation(station);
        return "redirect: /editTimetable";
    }

    @RequestMapping(value = "/addTrainStop", method = RequestMethod.POST)
    public String addTrainStop (@ModelAttribute(name = "trainStop") TimetableDTO trainStop) {
        //timetableService.addToTimetable(timetable);
        return "redirect: /editTimetable";
    }




}
