package com.taewon.project.kickoff.match;

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

    private String league;
    private String homeTeam;
    private String awayTeam;

    private LocalDateTime startTime;

    private Integer homeScore;
    private Integer awayScore;

    private String status; // SCHEDULED, LIVE, FINISHED

    // getters/setters
}
