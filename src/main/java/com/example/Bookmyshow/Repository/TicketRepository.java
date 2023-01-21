package com.example.Bookmyshow.Repository;

import com.example.Bookmyshow.Models.ShowSeatEntity;
import com.example.Bookmyshow.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {

}
