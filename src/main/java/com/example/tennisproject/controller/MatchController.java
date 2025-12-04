package com.example.tennisproject.controller;

import com.example.tennisproject.dto.requests.MatchRequest;
import com.example.tennisproject.dto.responses.MatchResponse;
import com.example.tennisproject.dto.responses.PlayerResponse;
import com.example.tennisproject.repository.MatchRepository;
import com.example.tennisproject.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// This class is in charge of holding our API endpoints (GET and POST)

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;



    // 1) Record a match result (POST call)
    @PostMapping
    public MatchResponse recordMatch(@RequestBody MatchRequest userRequest) {
        return matchService.recordMatch(userRequest);
    }


    // 2) Get match details (GET call)
    @GetMapping("/{id}")
    public MatchResponse getMatchDetails(@PathVariable Long id) {
        return matchService.getMatchDetails(id);
    }
}