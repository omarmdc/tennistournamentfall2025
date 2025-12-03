package com.example.tennisproject.service;

import com.example.tennisproject.dto.requests.TournamentRequest;
import com.example.tennisproject.dto.responses.TournamentResponse;
import com.example.tennisproject.entity.Player;
import com.example.tennisproject.entity.Tournament;
import com.example.tennisproject.repository.PlayerRepository;
import com.example.tennisproject.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private PlayerRepository playerRepository;   // for adding the players to the tournament later

    // Here we will create the logic of our program by making Helper methods, objects, and public functions
    // to deal with user's requests and responses (all by using the 'dto' files (Requests & Responses)).


    // Here we will create our Helper Methods: converter() and responseMaker()
    // These will help us convert and output info in a specific format (ex: adding the ID)

    private Tournament converter(TournamentRequest userRequest) {

        Tournament tournament = new Tournament();

        tournament.setName(userRequest.getName());
        tournament.setLocation(userRequest.getLocation());
        tournament.setStartDate(userRequest.getStartDate());
        tournament.setEndDate(userRequest.getEndDate());
        tournament.setPlayers(new ArrayList<>());

        return tournament;
    }


    private TournamentResponse responseMaker(Tournament tournament) {

        TournamentResponse response = new TournamentResponse();

        response.setId(tournament.getId());
        response.setName(tournament.getName());
        response.setLocation(tournament.getLocation());
        response.setStartDate(tournament.getStartDate());
        response.setEndDate(tournament.getEndDate());


        // adding the players to the tournament

        List<Long> responseIds = new ArrayList<>();
        if (tournament.getPlayers() != null) {
            for (Player player : tournament.getPlayers()) {
                responseIds.add(player.getId());
            }
        }
        response.setPlayerIds(responseIds);

        return response;
    }


    // Now, our Public Methods: getAllTournaments() | getTournamentById() | createTournament() | regPlayerInTournament()


    // 1. 'getAllTournaments()' Method
    public List<TournamentResponse> getAllTournaments() {

        List<Tournament> allTournaments = tournamentRepository.findAll();
        List<TournamentResponse> response = new ArrayList<>();

        for(Tournament t : allTournaments) {
            response.add(responseMaker(t));
        }
        return response;
    }


    // 2. 'getTournamentById' Method
    public TournamentResponse getTournamentById(Long id) {

        try {
            Tournament tourney = tournamentRepository.findById(id).get();
            return responseMaker(tourney);
        }
        catch (Exception e) {
            throw new RuntimeException("Oops! we weren't able to find a tournament with ID: " + id);
        }
    }


    // 3. 'createTournament()' Method
    public TournamentResponse createTournament(TournamentRequest userRequest) {

        Tournament tourney = converter(userRequest);
        Tournament savedTourney = tournamentRepository.save(tourney);

        return responseMaker(savedTourney);
    }


    // 4. 'regPlayerInTournament()' Method
    public TournamentResponse regPlayerInTournament(Long tourneyId, Long playerId) {

        Tournament tourney = tournamentRepository.findById(tourneyId).get();
        Player player = playerRepository.findById(playerId).get();

        if (tourney.getPlayers() == null) {
            tourney.setPlayers(new ArrayList<>());
        }

        // Making sure we avoid duplicates
        if (tourney.getPlayers().contains(player)) {
            throw new RuntimeException("Sorry, that player is already in the tournament!");
        }
        else {
            tourney.getPlayers().add(player);
        }

        Tournament savedTourney = tournamentRepository.save(tourney);

        return responseMaker(savedTourney);
    }
}




