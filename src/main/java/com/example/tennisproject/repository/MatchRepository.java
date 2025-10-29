package com.example.tennisproject.repository;

import com.example.tennisproject.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {

}
