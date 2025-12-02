package com.example.tennisproject.service;

import com.example.tennisproject.dto.requests.PlayerRequest;
import com.example.tennisproject.dto.responses.PlayerResponse;
import com.example.tennisproject.entity.Player;
import com.example.tennisproject.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    // Here we will create the logic of our program by making Helper methods, objects, and public functions
    // to deal with user's requests and responses (all by using the 'dto' files (Requests & Responses)).


    // Here we will create our Helper Methods: converter() and responseMaker()
    // These will help us convert and output info in a specific format (ex: adding the player ID)

    // converter()
    private Player converter(PlayerRequest userRequest) {
        Player player = new Player();
        player.setName(userRequest.getName());
        player.setAge(userRequest.getAge());
        player.setCountry(userRequest.getCountry());
        player.setWins(userRequest.getWins());
        player.setLosses(userRequest.getLosses());

        return player;
    }

    //responseMaker()
    private PlayerResponse responseMaker(Player player) {
        PlayerResponse response = new PlayerResponse();
        response.setId(player.getId());
        response.setName(player.getName());
        response.setAge(player.getAge());
        response.setCountry(player.getCountry());
        response.setWins(player.getWins());
        response.setLosses(player.getLosses());

        return response;
    }



    // Now, our Public Methods: getAllPlayers() | getPlayerById() | registerPlayer() | updatePlayer() | deletePlayer()


    //1. 'getAllPlayers()' Method
    public List<PlayerResponse> getAllPlayers() {

        List<Player> allPlayers = playerRepository.findAll();
        List<PlayerResponse> response = new ArrayList<>();

        for (Player player : allPlayers) {
            response.add(responseMaker(player));
        }

        return response;
    }


    //2. 'getPlayerById()' Method
    public PlayerResponse getPlayerById(Long id) {

        try {
            Player player =  playerRepository.findById(id).get();
            return responseMaker(player);
        }
        catch (Exception e) {
            throw new RuntimeException("Sorry, we weren't able to find a player with ID: " + id);
        }
    }


    // 3. 'registerPlayer()' Method
    public PlayerResponse registerPlayer(PlayerRequest userRequest) {

        Player player = converter(userRequest);
        Player savedPlayer = playerRepository.save(player);

        return responseMaker(savedPlayer);
    }
    
    
    // 4. 'updatePlayer()' Method
    public PlayerResponse updatePlayer(Long id, PlayerRequest updateRequest) {

        try {
            Player currPlayer = playerRepository.findById(id).get();

            currPlayer.setName(updateRequest.getName());
            currPlayer.setAge(updateRequest.getAge());
            currPlayer.setCountry(updateRequest.getCountry());
            currPlayer.setWins(updateRequest.getWins());
            currPlayer.setLosses(updateRequest.getLosses());

            Player newPlayer = playerRepository.save(currPlayer);

            return responseMaker(newPlayer);

        } catch (Exception e) {
            throw new RuntimeException("Sorry, we weren't able to update the player with ID: " + id);
        }
    }


    // 5. 'deletePlayer()' Method
    public void deletePlayer(Long id) {
        try {
            Player playerToDelete = playerRepository.findById(id).get();
            playerRepository.delete(playerToDelete);
        }
        catch (Exception e) {
            throw new RuntimeException("Sorry, we weren't able to find a player with ID: " + id);
        }
    }



}
