package com.example.Bookmyshow.Repository;

import com.example.Bookmyshow.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

    MovieEntity findByMovieName(String movieName);
}
