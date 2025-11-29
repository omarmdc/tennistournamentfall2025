package com.example.tennisproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {               // This is the Player table in our database


    // Each of these will be the columns of the 'Player' table

    @Id // Making it a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // When a new record is added, increment the number
    private Long id;

    private String playerName;

    private String playerCountry;

    private int playerAge;

    private int playerWins;

    private int playerLosses;

    // Create getters and setters for every attribute






}
