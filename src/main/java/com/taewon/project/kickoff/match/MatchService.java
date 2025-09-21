package com.taewon.project.kickoff.match;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.concurrent.*;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final RestClient restClient = RestClient.create();
    private final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    // 외부 API (샘플: football-data.org 같은 곳)
    public void refreshMatches() {
        List<String> apiUrls = List.of(
                "https://api.football-data.org/v4/matches", // 샘플 URL
                "https://api.football-data.org/v4/competitions/PL/matches"
        );

        apiUrls.forEach(url -> executor.submit(() -> {
            try {
                String response = restClient.get()
                        .uri(url)
                        .header("X-Auth-Token", "YOUR_API_KEY") // 실제 API 키 필요
                        .retrieve()
                        .body(String.class);

                // TODO: JSON 파싱해서 Match 객체로 변환
                System.out.println("Fetched from: " + url);
                System.out.println(response.substring(0, 200) + "...");

                // 여기서 matchRepository.save(...) 호출 예정

            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }
}