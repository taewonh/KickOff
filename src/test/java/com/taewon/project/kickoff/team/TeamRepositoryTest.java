package com.taewon.project.kickoff.team;

import com.taewon.project.kickoff.league.League;
import com.taewon.project.kickoff.league.LeagueRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @Test
    @DisplayName("Team 엔티티 저장 후 조회")
    void testSaveAndFind() {
        League league = new League();
        league.setName("La Liga");
        league.setCountry("Spain");
        leagueRepository.save(league);

        Team team = new Team();
        team.setName("Real Madrid");
        team.setCity("Madrid");
        team.setLeague(league);

        teamRepository.save(team);

        List<Team> teams = teamRepository.findAll();
        assertThat(teams).hasSize(1);
        assertThat(teams.get(0).getName()).isEqualTo("Real Madrid");
        assertThat(teams.get(0).getLeague().getName()).isEqualTo("La Liga");
    }
}
