package com.taewon.project.kickoff.league;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    public League saveLeague(League league) {
        return leagueRepository.save(league);
    }

    public League getLeagueById(Long id) {
        return leagueRepository.findById(id).orElse(null);
    }
}
