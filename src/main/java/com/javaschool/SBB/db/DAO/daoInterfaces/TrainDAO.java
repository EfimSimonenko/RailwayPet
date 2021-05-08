package com.javaschool.SBB.db.DAO.daoInterfaces;

import com.javaschool.SBB.db.entities.Train;

import java.util.List;

public interface TrainDAO {

    void create(Train train);

    Train findById(int id);

    List<Train> getAllTrains();


}
