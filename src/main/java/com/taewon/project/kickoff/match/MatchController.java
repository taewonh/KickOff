package com.taewon.project.kickoff.match;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @PostMapping("/refresh")
    public String refreshMatches() {
        matchService.refreshMatches();
        return "Refreshing matches (async)...";
    }
}