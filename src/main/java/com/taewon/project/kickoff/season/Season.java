package com.taewon.project.kickoff.season;

import com.taewon.project.kickoff.league.League;
import com.taewon.project.kickoff.match.Match;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "seasons")
@Data
public class Season {

    @Id @GeneratedValue
    private Long id;
    private String name; // 2025/2026
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private League league;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
    private List<Match> matches;
}
