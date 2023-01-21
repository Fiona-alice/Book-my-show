package com.example.Bookmyshow.Models;

import javax.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String mobile;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdOn;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedOn;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<TicketEntity> listOfTickets;
}
