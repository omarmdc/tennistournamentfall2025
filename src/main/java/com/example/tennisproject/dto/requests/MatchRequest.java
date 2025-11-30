package com.example.tennisproject.dto.requests;

import java.time.LocalDate;

public class MatchRequest {


    // These variables represent the specific requests (what the user wants)

    private Long player1Id;
    private Long player2Id;
    private Long winnerId;
    private Long tournamentId;
    private LocalDate matchDate;
    private String score;


    // Getters and Setters creation

    public Long getPlayer1Id() {
        return player1Id;
    }
    public void setPlayer1Id(Long player1Id) {
        this.player1Id = player1Id;
    }


    public Long getPlayer2Id() {
        return player2Id;
    }
    public void setPlayer2Id(Long player2Id) {
        this.player2Id = player2Id;
    }


    public Long getWinnerId() {
        return winnerId;
    }
    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }


    public Long getTournamentId() {
        return tournamentId;
    }
    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }


    public LocalDate getMatchDate() {
        return matchDate;
    }
    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }


    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }

}
