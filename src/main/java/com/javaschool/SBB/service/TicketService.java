package com.javaschool.SBB.service;

import com.javaschool.SBB.db.DAO.Mapper;
import com.javaschool.SBB.db.DAO.daoInterfaces.PassengerDAO;
import com.javaschool.SBB.db.DAO.daoInterfaces.TicketDAO;
import com.javaschool.SBB.db.DAO.daoInterfaces.TimetableDAO;
import com.javaschool.SBB.db.DTO.PassengerDTO;
import com.javaschool.SBB.db.DTO.SuitableRouteDTO;
import com.javaschool.SBB.db.DTO.TicketSearchDTO;
import com.javaschool.SBB.db.DTO.TrainDTO;
import com.javaschool.SBB.db.entities.*;
import com.javaschool.SBB.hepler.DateTimeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TicketService {

    @Autowired
    TimetableDAO timetableDAO;

    @Autowired
    TicketDAO ticketDAO;

    @Autowired
    PassengerDAO passengerDAO;

    @Autowired
    Mapper mapper;

    @Autowired
    DateTimeParser parser;



    public List<SuitableRouteDTO> getSuitableRoutes(TicketSearchDTO requestedData) {

        List<Timetable> trainsOnDepartureStation = timetableDAO.getTrainsOnDepartureStation(requestedData);
        List<Timetable> trainOnArrivalStation = timetableDAO.getTrainsOnArrivalStation(requestedData);
        List<SuitableRouteDTO> routes = new ArrayList<>();
        for(Timetable departure : trainsOnDepartureStation) {
            for(Timetable arrival : trainOnArrivalStation) {
                if(departure.getTrainId().getTrainName().equals(arrival.getTrainId().getTrainName()) &&
                  departure.getDepartureTime().compareTo(arrival.getArrivalTime()) < 0) {
                    SuitableRouteDTO route = new SuitableRouteDTO(departure.getTrainId(), departure.getStationId(),
                            arrival.getStationId(), parser.localDateTimeToString(departure.getDepartureTime()),
                            parser.localDateTimeToString(arrival.getArrivalTime()));
                    routes.add(route);
                }
            }
        }
        return routes;
    }

    public boolean hasEmptySeats(SuitableRouteDTO route) {

        List<Station> stationList = timetableDAO.getTrainRoute(route);  //gets all stations for the train
        List<Ticket> ticketsBoughtForTrain = ticketDAO.getTicketsByTrain(route.getTrain());  //gets all tickets bought for the train
        int departureStationIndex = stationList.indexOf(route.getDepartureStation());
        int arrivalStationIndex = stationList.indexOf(route.getArrivalStation());
        Map<Integer, Integer> seatsCount = new HashMap<>();
        for(Station station : stationList) {
            seatsCount.put(stationList.indexOf(station), 0);
        }

        for(Ticket ticket : ticketsBoughtForTrain) {
           for (int i = stationList.indexOf(ticket.getStationFrom()); i <= stationList.indexOf(ticket.getStationTo()); i++) {
               seatsCount.put(i, seatsCount.get(i) + 1);
           }
        }
        for (int i = departureStationIndex; i <= arrivalStationIndex; i++) {
            if (seatsCount.get(i) >= route.getTrain().getNumberOfSeats()) return false;
        }
        return true;

       /* if (ticketsBoughtForTrain.size() < route.getTrain().getNumberOfSeats()) {
            return true;
        } else return false;

        */
    }

    public void addTicket(SuitableRouteDTO route, PassengerDTO passengerDTO) {
        Passenger passenger = mapper.dtoToEntity(passengerDTO);
        if(passengerDAO.findByNameAndDateOfBirth(passenger.getFirstName(), passenger.getLastName(), passenger.getDateOfBirth()).size() == 0) {
            passengerDAO.createPassenger(passenger);
        }
        passenger = passengerDAO.findByNameAndDateOfBirth(passenger.getFirstName(), passenger.getLastName(), passenger.getDateOfBirth()).get(0);
        ticketDAO.addTicket(route, passenger);
    }

    public boolean hasPassengerWithSameNameAndDateOfBirth(PassengerDTO passengerDTO, Train train) {
        Passenger passenger = mapper.dtoToEntity(passengerDTO);
        return ticketDAO.hasPassengerWithSameNameAndDateOfBirth(passenger, train);
    }

    public List<Ticket> getTicketsByTrain(Train train) {
        List<Ticket> passengersOnTrain = ticketDAO.getTicketsByTrain(train);
        return passengersOnTrain;
    }


}
