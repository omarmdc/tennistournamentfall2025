package com.example.tennisproject.service;

import com.example.tennisproject.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    // Here we will create the logic of our program by making Helper methods, objects, and public functions
    // to deal with user's requests and responses (all by using the 'dto' files (Requests & Responses)).


    // Here we will create our Helper Methods: converter() and responseMaker()
    // These will help us convert and output info in a specific format (ex: adding the player ID)



}
