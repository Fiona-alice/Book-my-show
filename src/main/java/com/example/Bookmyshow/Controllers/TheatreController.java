package com.example.Bookmyshow.Controllers;

import com.example.Bookmyshow.Dtos.TheatreRequestDto;
import com.example.Bookmyshow.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/add")
    public String addTheatre(@RequestBody TheatreRequestDto theatreRequestDto){
        return theatreService.createTheatre(theatreRequestDto);
    }
}
