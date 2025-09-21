package com.taewon.project.kickoff.league;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class LeagueRepositoryTest {

    @Autowired
    private LeagueRepository leagueRepository;

    @Test
    @DisplayName("League 엔티티 저장 후 조회")
    void testSaveAndFind() {
        League league = new League();
        league.setName("Premier League");
        league.setCountry("England");

        leagueRepository.save(league);

        List<League> leagues = leagueRepository.findAll();
        assertThat(leagues).hasSize(1);
        assertThat(leagues.get(0).getName()).isEqualTo("Premier League");
    }
}
