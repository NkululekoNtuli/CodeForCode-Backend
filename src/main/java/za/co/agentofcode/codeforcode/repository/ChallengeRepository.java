package za.co.agentofcode.codeforcode.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import za.co.agentofcode.codeforcode.model.Challenges;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenges, Integer> {
    Challenges findChallengesByName(String name);

    List<Challenges> findAllByDifficulty(String difficulty);

    List<Challenges> findAllByLanguage(String language);

    List<Challenges> findAllByLanguageAndDifficulty(String language, String difficulty);
}
