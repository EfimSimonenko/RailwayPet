package com.javaschool.SBB.service;

import com.javaschool.SBB.db.DAO.daoInterfaces.StationDAO;
import com.javaschool.SBB.db.entities.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    StationDAO stationDAO;

    public void createStation(Station station) {
        stationDAO.createStation(station);
    }

    public List<Station> listAllStations() {
       return  stationDAO.listAllStations();
    }

    public Station getStationById(int id) {
       return this.stationDAO.getStationById(id);
    }

}
