package za.co.agentofcode.codeforcode.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import za.co.agentofcode.codeforcode.model.Challenges;

public interface ChallengeRepository extends JpaRepository<Challenges, Integer> {

}
