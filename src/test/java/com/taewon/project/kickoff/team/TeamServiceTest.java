package com.taewon.project.kickoff.team;

import com.taewon.project.kickoff.league.League;
import com.taewon.project.kickoff.league.LeagueRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @Test
    @DisplayName("TeamService - 모든 팀 조회")
    void testGetAllTeams() {
        League league = new League();
        league.setName("Ligue 1");
        league.setCountry("France");
        leagueRepository.save(league);

        Team team = new Team();
        team.setName("PSG");
        team.setCity("Paris");
        team.setLeague(league);
        teamRepository.save(team);

        List<Team> teams = teamService.getAllTeams();
        assertThat(teams).isNotEmpty();
        assertThat(teams.get(0).getName()).isEqualTo("PSG");
    }

    @Test
    @DisplayName("TeamService - 단일 팀 조회")
    void testGetTeamById() {
        League league = new League();
        league.setName("Eredivisie");
        league.setCountry("Netherlands");
        leagueRepository.save(league);

        Team team = new Team();
        team.setName("Ajax");
        team.setCity("Amsterdam");
        team.setLeague(league);
        Team saved = teamRepository.save(team);

        Team found = teamService.getTeamById(saved.getId());
        assertThat(found).isNotNull();
        assertThat(found.getLeague().getName()).isEqualTo("Eredivisie");
    }
}
