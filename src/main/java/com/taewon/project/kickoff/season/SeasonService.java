package com.taewon.project.kickoff.season;

import com.taewon.project.kickoff.league.League;
import com.taewon.project.kickoff.league.LeagueRepository;
import com.taewon.project.kickoff.team.Team;
import com.taewon.project.kickoff.team.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SeasonService {

    private final LeagueRepository leagueRepository;
    private final SeasonRepository seasonRepository;
    private final TeamRepository teamRepository;

    public void initializeSeason(String seasonName, LocalDate startDate, LocalDate endDate) {
        List<League> leagues = leagueRepository.findAllByTier(1); // 1부 리그만
        for (League league : leagues) {

            Season season = new Season();
            season.setLeague(league);
            season.setName(seasonName);
            season.setStartDate(startDate);
            season.setEndDate(endDate);
            seasonRepository.save(season);

            // 팀 생성
            Map<String, List<String>> leagueTeams = getTeamsByLeague();
            List<String> teams = leagueTeams.get(league.getName());
            if (teams != null) {
                for (String teamName : teams) {
                    Team team = new Team();
                    team.setLeague(league);
                    team.setSeason(season);
                    team.setName(teamName);
                    teamRepository.save(team);
                }
            }
        }
    }

    private Map<String, List<String>> getTeamsByLeague() {
        return Map.of(
                "EPL", List.of("Arsenal","Chelsea","Liverpool","Man City","Man United","Tottenham","Leicester","West Ham","Everton","Newcastle"),
                "Bundesliga", List.of("Bayern","Dortmund","Leverkusen","RB Leipzig","Schalke","Borussia Mönchengladbach","Wolfsburg","Eintracht Frankfurt","Freiburg","Union Berlin"),
                "Serie A", List.of("Juventus","Inter Milan","AC Milan","Napoli","Roma","Lazio","Atalanta","Fiorentina","Sassuolo","Torino"),
                "La Liga", List.of("Real Madrid","Barcelona","Atletico Madrid","Sevilla","Valencia","Villarreal","Real Sociedad","Athletic Bilbao","Betis","Celta Vigo")
        );
    }
}

