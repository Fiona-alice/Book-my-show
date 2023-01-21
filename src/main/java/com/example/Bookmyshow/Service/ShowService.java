package com.example.Bookmyshow.Service;

import com.example.Bookmyshow.Dtos.ShowRequestDto;
import com.example.Bookmyshow.Models.*;
import com.example.Bookmyshow.Repository.MovieRepository;
import com.example.Bookmyshow.Repository.ShowRepository;
import com.example.Bookmyshow.Repository.ShowSeatRepository;
import com.example.Bookmyshow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;

    public String addShow(ShowRequestDto showRequestDto){
        ShowEntity showEntity = ShowEntity.builder().showDate(showRequestDto.getShowDate()).
                showTime(showRequestDto.getShowTime()).
                multiplier(showRequestDto.getMultiplier()).build();

        //You need to get the movieRepo
        MovieEntity movieEntity = movieRepository.findByMovieName(showRequestDto.getMovieName());

        //You need to get the theater Repository

        TheatreEntity theatreEntity = theatreRepository.findById(showRequestDto.getTheatreId()).get();

        showEntity.setTheatre(theatreEntity);
        showEntity.setMovie(movieEntity);

        movieEntity.getListOfShows().add(showEntity);
        theatreEntity.getListOfShows().add(showEntity);
        //theaterRepository.save(theaterEntity);

        List<ShowSeatEntity> seatEntityList = createShowSeats(theatreEntity.getTheatreSeatEntityList());

        showEntity.setListOfSeats(seatEntityList);

        //For each ShowSeat : we need to mark that to which show it belongs (foriegn key will be filled )
        for(ShowSeatEntity showSeat:seatEntityList){
            showSeat.setShow(showEntity);
        }

        movieRepository.save(movieEntity);
        theatreRepository.save(theatreEntity);
        //showRepository.save(showEntity); this doesnt need to be called bcz parent save function is being called.

        return "Show added successfully";

    }

    public List<ShowSeatEntity> createShowSeats(List<TheatreSeatEntity> theatreSeatEntityList){


        List<ShowSeatEntity> seats = new ArrayList<>();

        for(TheatreSeatEntity theatreSeat: theatreSeatEntityList){

            ShowSeatEntity showSeat = ShowSeatEntity.builder().seatNo(theatreSeat.
                    getSeatNo()).seatType(theatreSeat.getSeatType()).build();
            seats.add(showSeat);
        }

        showSeatRepository.saveAll(seats);

        return seats;
    }
}
