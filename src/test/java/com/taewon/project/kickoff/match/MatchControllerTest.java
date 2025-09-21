package com.taewon.project.kickoff.match;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MatchRepository matchRepository;

    @Test
    @DisplayName("GET /api/matches - 모든 경기 조회")
    void testGetAllMatches() throws Exception {
        Match match = new Match();
        match.setLeague("Bundesliga");
        match.setHomeTeam("Bayern");
        match.setAwayTeam("Dortmund");
        match.setStartTime(LocalDateTime.now());
        match.setHomeScore(2);
        match.setAwayScore(2);
        match.setStatus("FINISHED");

        matchRepository.save(match);

        mockMvc.perform(get("/api/matches"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].league").value("Bundesliga"))
                .andExpect(jsonPath("$[0].homeTeam").value("Bayern"));
    }
}
