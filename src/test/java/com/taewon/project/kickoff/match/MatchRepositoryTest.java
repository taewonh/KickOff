package com.taewon.project.kickoff.match;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class MatchRepositoryTest {

    @Autowired
    private MatchRepository matchRepository;

    @Test
    @DisplayName("Match 엔티티 저장 후 조회")
    void testSaveAndFind() {
        Match match = new Match();
        match.setLeague("Premier League");
        match.setHomeTeam("Team A");
        match.setAwayTeam("Team B");
        match.setStartTime(LocalDateTime.now());
        match.setHomeScore(1);
        match.setAwayScore(2);
        match.setStatus("FINISHED");

        matchRepository.save(match);

        List<Match> matches = matchRepository.findAll();
        assertThat(matches).hasSize(1);
        assertThat(matches.get(0).getLeague()).isEqualTo("Premier League");
    }
}
