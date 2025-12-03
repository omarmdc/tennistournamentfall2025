package com.example.tennisproject.dto.responses;

import java.time.LocalDate;
import java.util.List;

public class TournamentResponse {

    // These variables represent the specific responses (what the user sees)

    private Long id;                    // added (not in request)
    private String name;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Long> playerIds;


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


    public List<Long> getPlayerIds() {
        return playerIds;
    }


    public void setPlayerIds(List<Long> playerIds) {
        this.playerIds = playerIds;
    }
}
