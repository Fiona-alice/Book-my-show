package com.example.Bookmyshow.Models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "theatre")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String city;
    private String address;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    List<TheatreSeatEntity> theatreSeatEntityList;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    List<ShowEntity> listOfShows;


}
