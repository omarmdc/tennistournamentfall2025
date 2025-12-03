package com.example.tennisproject.controller;

import com.example.tennisproject.dto.requests.TournamentRequest;
import com.example.tennisproject.dto.responses.TournamentResponse;
import com.example.tennisproject.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// This class is in charge of holding our API endpoints (GET and POST)



@RestController
@RequestMapping("/tournaments")
public class TournamentController {


    @Autowired
    private TournamentService tournamentService;



    // 1) Get all the tournaments (GET call)
    @GetMapping
    public List<TournamentResponse> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }


    // 2) Get tournament by ID (GET call)
    @GetMapping("/{id}")
    public TournamentResponse getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }


    // 3) Create a new tournament (POST call)
    @PostMapping
    public TournamentResponse createTournament(@RequestBody TournamentRequest userRequest) {
        return tournamentService.createTournament(userRequest);
    }


    // 4) Register player(s) to a tournament (POST call)
    @PostMapping("/{id}/players/{playerId}")
    public TournamentResponse regPlayerInTournament(@PathVariable Long id, @PathVariable Long playerId) {
        return tournamentService.regPlayerInTournament(id, playerId);
    }
}
