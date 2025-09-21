package com.taewon.project.kickoff.team;

import com.taewon.project.kickoff.league.League;
import com.taewon.project.kickoff.season.Season;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "teams")
@Data
public class Team {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String city;

    @ManyToOne
    private League league;

    @ManyToOne
    private Season season; // 시즌별 소속 팀
}
