package com.javaschool.SBB.service;

import com.javaschool.SBB.db.DAO.Mapper;
import com.javaschool.SBB.db.DAO.daoInterfaces.TrainDAO;
import com.javaschool.SBB.db.DTO.SuitableRouteDTO;
import com.javaschool.SBB.db.DTO.TrainDTO;
import com.javaschool.SBB.db.entities.Train;
import com.javaschool.SBB.hepler.DateTimeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainService {

    @Autowired
    TrainDAO trainDAO;

    @Autowired
    Mapper mapper;

    @Autowired
    DateTimeParser dateTimeParser;

    public void createTrain(Train train) {
        trainDAO.create(train);
    }

    public List<Train> getAllTrains() {
        return trainDAO.getAllTrains();
    }

    public boolean moreThenTenMinutesBeforeDeparture(SuitableRouteDTO selectedRoute) {
        LocalDateTime time = dateTimeParser.stringToLocalDateTime(selectedRoute.getDepartureTime());
        Duration duration = Duration.between(LocalDateTime.now(), time);
        Duration tenMinutes = Duration.ofMinutes(10);
        if (duration.compareTo(tenMinutes) < 0) {
            return false;
        } else return true;
    }

    public Train getByName(String trainName) {
        return trainDAO.getByName(trainName);
    }
}
