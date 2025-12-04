package com.example.tennisproject.service;

import com.example.tennisproject.dto.requests.MatchRequest;
import com.example.tennisproject.dto.responses.MatchResponse;
import com.example.tennisproject.dto.responses.PlayerResponse;
import com.example.tennisproject.entity.Match;
import com.example.tennisproject.entity.Player;
import com.example.tennisproject.entity.Tournament;
import com.example.tennisproject.repository.MatchRepository;
import com.example.tennisproject.repository.PlayerRepository;
import com.example.tennisproject.repository.TournamentRepository;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    // Here we will create the logic of our program by making a helper method, objects, and public functions
    // to deal with user's requests and responses (all by using the 'dto' files (Requests & Responses))

    // We will create a Helper Method: responseMaker()
    // It will help us convert and output info in a specific format (ex: adding the ID's)

    private MatchResponse responseMaker(Match match) {

        MatchResponse response = new MatchResponse();

        response.setId(match.getId());
        response.setPlayer1Id(match.getPlayer1().getId());
        response.setPlayer2Id(match.getPlayer2().getId());
        response.setWinnerId(match.getWinner().getId());
        response.setTournamentId(match.getTournament().getId());
        response.setMatchDate(match.getMatchDate());
        response.setScore(match.getScore());

        return response;
    }


    // Now, our Public Methods: recordMatch() | getMatchDetails() | getPlayerRankings()

    // 1) 'recordMatch' Method
    public MatchResponse recordMatch(MatchRequest userRequest) {

        // get tournament
        Tournament tournament = tournamentRepository.findById(userRequest.getTournamentId()).get();


        // get the 2 players that will play against each other
        Player player1 = playerRepository.findById(userRequest.getPlayer1Id()).get();
        Player player2 = playerRepository.findById(userRequest.getPlayer2Id()).get();


        // Making sure there are no invalid match records (e.g., null player values or players not in the same tournament).
        // Making sure the 2 players are registered before playing any matches.
        if (tournament.getPlayers() == null) {
            throw new RuntimeException("Sorry, players must be registered");
        }
        if (!tournament.getPlayers().contains(player1) && !tournament.getPlayers().contains(player2)) {
            throw new RuntimeException("Sorry, none of the players are registered in the tournament yet");
        }
        else if (!tournament.getPlayers().contains(player1) || !tournament.getPlayers().contains(player2)) {
            throw new RuntimeException("Sorry, 1 of the 2 players is not registered yet");
        }


        // declare the winner
        Player winner = playerRepository.findById(userRequest.getWinnerId()).get();

        // Make sure winner is either player1 or player2
        if (!winner.getId().equals(player1.getId()) && !winner.getId().equals(player2.getId())) {
            throw new RuntimeException("Invalid winner, you must choose either Player 1 or Player 2");
        }

        // Update players' stats after match (WIN or LOSS to each)
        if (player1.getId().equals(winner.getId())) {

            player1.setWins(player1.getWins() + 1);
            player2.setLosses(player2.getLosses() + 1);
        }
        else if (player2.getId().equals(winner.getId())){

            player2.setWins(player2.getWins() + 1);
            player1.setLosses(player1.getLosses() + 1);
        }

        playerRepository.save(player1);
        playerRepository.save(player2);



        // create the match
        Match match = new Match();

        match.setTournament(tournament);
        match.setMatchDate(userRequest.getMatchDate());
        match.setPlayer1(player1);
        match.setPlayer2(player2);
        match.setScore(userRequest.getScore());
        match.setWinner(winner);


        // Save the finished version of the match created
        Match finished = matchRepository.save(match);

        return responseMaker(finished);
    }


    // 2) 'getMatchDetails()' Method
    public MatchResponse getMatchDetails(Long id) {

        try {
            Match match = matchRepository.findById(id).get();
            return responseMaker(match);
        }
        catch (Exception e) {
            throw new RuntimeException("Oops, we couldn't find a match with ID: " + id);
        }
    }

    // 3) 'getPlayersRankings' Method
    public List<PlayerResponse> getPlayersRankings() {

        List<Player> players = playerRepository.findAll();

        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player player1, Player player2) {
                return player2.getWins() - player1.getWins();   // if return num is negative, player1 comes first
            }                                                   // else, player 2 comes first
        });

        // Pass response > object > list
        List<PlayerResponse> rankingsList = new ArrayList<>();

        for (Player player : players) {

            PlayerResponse currPlayer = new PlayerResponse();

            currPlayer.setId(player.getId());
            currPlayer.setName(player.getName());
            currPlayer.setAge(player.getAge());
            currPlayer.setCountry(player.getCountry());
            currPlayer.setWins(player.getWins());
            currPlayer.setLosses(player.getLosses());

            rankingsList.add(currPlayer);
        }
        return rankingsList;
    }
}
