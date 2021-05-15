package com.javaschool.SBB.db.DAO.daoInterfaces;

import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Train;

import java.util.List;

public interface StationDAO {

    void createStation(Station station);

    List<Station> listAllStations();

    Station getStationById(int id);

    Station findByName(String stationName);

}
