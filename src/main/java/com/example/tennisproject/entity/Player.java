package com.example.tennisproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {

    @Id // Making it a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // When a new record is added, increment the number
    private Long id;

    // Now we create getters and setters
}
