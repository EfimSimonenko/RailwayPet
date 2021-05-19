package com.javaschool.SBB.db.DAO;

import com.javaschool.SBB.db.DAO.daoInterfaces.StationDAO;
import com.javaschool.SBB.db.DAO.daoInterfaces.TimetableDAO;
import com.javaschool.SBB.db.DAO.daoInterfaces.TrainDAO;
import com.javaschool.SBB.db.DTO.PassengerDTO;
import com.javaschool.SBB.db.DTO.TimetableDTO;
import com.javaschool.SBB.db.DTO.TrainDTO;
import com.javaschool.SBB.db.entities.Passenger;
import com.javaschool.SBB.db.entities.Station;
import com.javaschool.SBB.db.entities.Timetable;
import com.javaschool.SBB.db.entities.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Mapper {

    @Autowired
    TimetableDAO timetableDAO;
    @Autowired
    TrainDAO trainDAO;
    @Autowired
    StationDAO stationDAO;

    public Timetable dtoToEntity(TimetableDTO timetableDTO) {
        Train train = trainDAO.getByName(timetableDTO.getTrainId().getTrainName());
        Station station = stationDAO.findByName(timetableDTO.getStationId().getStationName());
        LocalDateTime arrivalTime = LocalDateTime.parse(timetableDTO.getArrivalTime(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        LocalDateTime departureTime = LocalDateTime.parse(timetableDTO.getDepartureTime(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

        return new Timetable(train, station, arrivalTime, departureTime);
    }

    public TimetableDTO entityToDto(Timetable timetable) {
        String arrivalTime = timetable.getArrivalTime().toString().replace("T", " ");
        String departureTime = timetable.getDepartureTime().toString().replace("T", " ");
        return new TimetableDTO(timetable.getTrainId(), timetable.getStationId(), arrivalTime, departureTime);
    }

    public TrainDTO entityToDto(Train train) {
        return new TrainDTO(train.getId(), train.getTrainName(), train.getNumberOfSeats());
    }

    public Passenger dtoToEntity(PassengerDTO passengerDTO) {
        LocalDate dateOfBirth = LocalDate.parse(passengerDTO.getDateOfBirth(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return new Passenger(passengerDTO.getFirstName(),passengerDTO.getLastName(),
                dateOfBirth);
    }
}
