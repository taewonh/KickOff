package com.taewon.project.kickoff.match;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MatchServiceTest {

    @Autowired
    private MatchService matchService;

    @Autowired
    private MatchRepository matchRepository;

    @Test
    @DisplayName("MatchService - 모든 경기 조회")
    void testGetAllMatches() {
        Match match = new Match();
        match.setLeague("La Liga");
        match.setHomeTeam("Real Madrid");
        match.setAwayTeam("Barcelona");
        match.setStartTime(LocalDateTime.now());
        match.setHomeScore(3);
        match.setAwayScore(1);
        match.setStatus("FINISHED");

        matchRepository.save(match);

        List<Match> matches = matchService.getAllMatches();
        assertThat(matches).isNotEmpty();
        assertThat(matches.get(0).getLeague()).isEqualTo("La Liga");
    }

    @Test
    @DisplayName("MatchService - 외부 API refresh 테스트 (동기화)")
    void testRefreshMatches() {
        // 실제 외부 API 호출을 Mocking 하는게 안전
        // 여기서는 단순 실행 테스트
        matchService.refreshMatches();

        // 리턴값이 없으므로 실행 오류가 없는지만 확인
        assertThat(true).isTrue();
    }
}
