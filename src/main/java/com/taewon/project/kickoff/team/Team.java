package com.taewon.project.kickoff.team;

import com.taewon.project.kickoff.league.League;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "teams")
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String logoUrl; // 팀 로고 URL 등

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    // getters / setters
}
