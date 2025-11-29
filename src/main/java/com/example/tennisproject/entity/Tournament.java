package com.example.tennisproject.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Tournament {               // This is the 'Tournament' table in our database

    // Each of these will be the columns of the 'Tournament' table

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "tournament_players",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players;

    // Now we create getters and setters for every attribute

}
