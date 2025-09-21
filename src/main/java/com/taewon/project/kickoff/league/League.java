package com.taewon.project.kickoff.league;

import com.taewon.project.kickoff.season.Season;
import com.taewon.project.kickoff.team.Team;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "leagues")
@Data
public class League {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String country;

    private Integer tier; // 1부 리그인지 2부 리그인지 구분

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    private List<Team> teams;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    private List<Season> seasons;
}
