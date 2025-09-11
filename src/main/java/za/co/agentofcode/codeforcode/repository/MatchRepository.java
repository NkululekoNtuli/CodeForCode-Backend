package za.co.agentofcode.codeforcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.agentofcode.codeforcode.model.Matches;
import za.co.agentofcode.codeforcode.model.Users;

import java.util.List;

public interface MatchRepository extends JpaRepository<Matches, Integer> {
    List<Matches> findMatchByPlayer1(Users users);
}
