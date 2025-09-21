package com.taewon.project.kickoff.league;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LeagueServiceTest {

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private LeagueRepository leagueRepository;

    @Test
    @DisplayName("LeagueService - 모든 리그 조회")
    void testGetAllLeagues() {
        League league = new League();
        league.setName("Bundesliga");
        league.setCountry("Germany");
        leagueRepository.save(league);

        List<League> leagues = leagueService.getAllLeagues();
        assertThat(leagues).isNotEmpty();
        assertThat(leagues.get(0).getName()).isEqualTo("Bundesliga");
    }

    @Test
    @DisplayName("LeagueService - 단일 리그 조회")
    void testGetLeagueById() {
        League league = new League();
        league.setName("Serie A");
        league.setCountry("Italy");
        League saved = leagueRepository.save(league);

        League found = leagueService.getLeagueById(saved.getId());
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("Serie A");
    }
}
