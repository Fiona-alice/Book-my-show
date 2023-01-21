package com.example.Bookmyshow.Models;

import com.example.Bookmyshow.Enums.SeatType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="theatreSeat")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TheatreSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "seat_no", nullable = false)
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private int rate;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatre;

    public TheatreSeatEntity(String seatNo, SeatType seatType, int rate) {
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.rate = rate;
    }
}
