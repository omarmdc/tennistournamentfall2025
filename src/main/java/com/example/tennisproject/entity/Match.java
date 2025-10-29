package com.example.tennisproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Match {


    @ManyToOne
    @JoinColumn(name = "player1_id")
    private Player player1;


    // getters and setters
}
