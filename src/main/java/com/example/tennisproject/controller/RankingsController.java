package com.example.tennisproject.controller;

import com.example.tennisproject.dto.responses.PlayerResponse;
import com.example.tennisproject.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// This class is in charge of holding our API endpoints (GET)

@RestController
@RequestMapping("/rankings")
public class RankingsController {

    @Autowired
    private MatchService matchService;



    // 1) Get players rankings sorted
    @GetMapping
    public List<PlayerResponse> getPlayersRanking() {
        return matchService.getPlayersRankings();
    }
}
