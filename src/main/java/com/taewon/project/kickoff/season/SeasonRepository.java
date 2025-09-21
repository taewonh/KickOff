package com.taewon.project.kickoff.season;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    // 필요하면 시즌별 조회 메소드 추가 가능
    // 예: findByLeagueIdAndName
}
