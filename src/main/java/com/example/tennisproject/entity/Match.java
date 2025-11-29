package com.example.tennisproject.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Match {                // This is the 'Match' table in our database


    // Each of these will be the columns of the 'Match' table


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player1_id")
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player2_id")
    private Player player2;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Player winner;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournamentName;

    private LocalDate matchDate;

    private String score;


    // Now we create getters and setters

}
