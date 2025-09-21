package com.taewon.project.kickoff.league;

import com.taewon.project.kickoff.team.Team;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "leagues")
@Data
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    private List<Team> teams;

    // getters / setters
}
