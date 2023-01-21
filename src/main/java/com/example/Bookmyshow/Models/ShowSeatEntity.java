package com.example.Bookmyshow.Models;

import com.example.Bookmyshow.Enums.SeatType;
import com.example.Bookmyshow.Enums.SeatType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "show_seats")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean booked;

    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;

    @ManyToOne
    @JoinColumn
    private TicketEntity ticket;

}
