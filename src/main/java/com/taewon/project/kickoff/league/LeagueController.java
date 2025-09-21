package com.taewon.project.kickoff.league;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leagues")
public class LeagueController {

    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping
    public List<League> getAllLeagues() {
        return leagueService.getAllLeagues();
    }

    @PostMapping
    public League createLeague(@RequestBody League league) {
        return leagueService.saveLeague(league);
    }

    @GetMapping("/{id}")
    public League getLeague(@PathVariable Long id) {
        return leagueService.getLeagueById(id);
    }
}
