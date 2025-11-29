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

    private String name;

    private String country;

    private int age;

    private int wins;

    private int losses;


    // Getters and Setters creation

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

}
