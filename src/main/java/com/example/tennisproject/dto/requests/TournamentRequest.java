package com.example.tennisproject.dto.requests;

import java.time.LocalDate;
import java.util.List;

public class TournamentRequest {


    // These variables represent the specific requests (what the user wants)

    private String name;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;


    // Getters and Setters creation

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }


    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
