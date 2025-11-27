package com.example.tennisproject.entity;

import jakarta.persistence.*;

@Entity
public class Match {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player1_id")
    private Player player1;


    // Now we create getters and setters
    // Testing my github connection
}
