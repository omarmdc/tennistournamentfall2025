package com.example.tennisproject.controller;

import com.example.tennisproject.dto.requests.PlayerRequest;
import com.example.tennisproject.dto.responses.PlayerResponse;
import com.example.tennisproject.entity.Player;
import com.example.tennisproject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// This class is in charge of holding our API endpoints (GET, POST, PUT, and DELETE)

@RestController
@RequestMapping("/players")
public class PlayerController {


    @Autowired
    private PlayerService playerService;



    // 1) Getting all the players (GET call)
   @GetMapping
    public List<PlayerResponse> getAllPlayers() {
        return playerService.getAllPlayers();
    }


    // 2) Get a Player by ID (GET call)
    @GetMapping("/{id}")
    public PlayerResponse getPlayerById(@PathVariable Long id) {
       return playerService.getPlayerById(id);
    }


    // 3) Register a new Player (POST call)
    @PostMapping
    public PlayerResponse registerPlayer(@RequestBody PlayerRequest player) {
       return playerService.registerPlayer(player);
    }


    // 4) Update an existing player (PUT call)
    @PutMapping("/{id}")
    public PlayerResponse updatePlayer(@PathVariable Long id, @RequestBody PlayerRequest player) {
       return playerService.updatePlayer(id, player);
    }


    // 5) Delete an existing player (DELETE call)
    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id) {
       playerService.deletePlayer(id);
       return "The player was successfully deleted!";
    }
}