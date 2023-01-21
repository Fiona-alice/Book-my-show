package com.example.Bookmyshow.Repository;

import com.example.Bookmyshow.Models.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<TheatreEntity,Integer> {

    TheatreEntity findByNameAndCity(String name,String city);
}
