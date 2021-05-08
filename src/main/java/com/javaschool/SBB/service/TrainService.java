package com.javaschool.SBB.service;

import com.javaschool.SBB.db.DAO.daoInterfaces.TrainDAO;
import com.javaschool.SBB.db.entities.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    TrainDAO trainDAO;

    public void createTrain(Train train) {
        trainDAO.create(train);
    }

    public List<Train> getAllTrains() {
        return trainDAO.getAllTrains();
    }
}
