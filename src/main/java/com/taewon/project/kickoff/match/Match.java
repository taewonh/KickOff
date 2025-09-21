package com.taewon.project.kickoff.match;

import com.taewon.project.kickoff.league.League;
import com.taewon.project.kickoff.team.Team;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
@Data
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    private LocalDateTime startTime;

    private Integer homeScore;
    private Integer awayScore;

    private String status; // SCHEDULED, LIVE, FINISHED

    // getters/setters
}
