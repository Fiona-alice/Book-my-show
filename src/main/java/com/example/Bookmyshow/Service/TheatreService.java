package com.example.Bookmyshow.Service;

import com.example.Bookmyshow.Dtos.TheatreRequestDto;
import com.example.Bookmyshow.Enums.SeatType;
import com.example.Bookmyshow.Models.TheatreEntity;
import com.example.Bookmyshow.Models.TheatreSeatEntity;
import com.example.Bookmyshow.Repository.TheatreRepository;
import com.example.Bookmyshow.Repository.TheatreSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreSeatRepository theatreSeatRepository;
    @Autowired
    TheatreRepository theatreRepository;

    public String createTheatre(TheatreRequestDto theatreRequestDto){
        TheatreEntity theatre = TheatreEntity.builder().city(theatreRequestDto.getCity()).
                name(theatreRequestDto.getName()).
                address(theatreRequestDto.getAddress()).build();

        List<TheatreSeatEntity> theatreSeats = createTheatreSeats();

        theatre.setTheatreSeatEntityList(theatreSeats); //bi directional mapping

        //For each theater Seat : we need to set the theaterEntity
        for(TheatreSeatEntity theatreSeat : theatreSeats){
            theatreSeat.setTheatre(theatre);
        }

        theatreRepository.save(theatre);

        return "Theater added successfully";
    }

    private List<TheatreSeatEntity> createTheatreSeats(){

        List<TheatreSeatEntity> seats = new ArrayList<>();

        //Optimize by adding loop
        for(int i=0;i<5;i++){

            char ch = (char)('A'+i);

            String seatNo  = "1"+ ch;
            TheatreSeatEntity theaterSeat = new TheatreSeatEntity(seatNo, SeatType.CLASSIC,100);
            seats.add(theaterSeat);
        }
        for(int i=0;i<5;i++){
            char ch = (char)('A'+i);
            String seatNo  = "2"+ ch;
            TheatreSeatEntity theaterSeat = new TheatreSeatEntity(seatNo,SeatType.PLATINUM,200);
            seats.add(theaterSeat);
        }
        theatreSeatRepository.saveAll(seats);

        return seats;

    }
}
