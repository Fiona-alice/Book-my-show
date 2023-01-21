package com.example.Bookmyshow.Models;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name ="tickets")
@Data
@NoArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String alloted_seats;
    private String allocated_users;
    private int amount;
    private Date booked_at;

    @ManyToOne
    @JoinColumn
    private UserEntity user;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;

    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> bookedSeats;


}
