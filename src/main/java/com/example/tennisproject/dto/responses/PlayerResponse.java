package com.example.tennisproject.dto.responses;

public class PlayerResponse {

    // These variables represent the specific responses (what the user sees)

    private Long id;                        // added (not in request)
    private String name;
    private int age;
    private String country;
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


    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }


    public int getLosses() {
        return losses;
    }
    public void setLosses(int losses) {
        this.losses = losses;
    }


    public int getWins() {
        return wins;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
}
