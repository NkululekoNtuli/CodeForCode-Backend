package za.co.agentofcode.codeforcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.agentofcode.codeforcode.model.Matches;
import za.co.agentofcode.codeforcode.model.Users;

import java.time.LocalDate;
import java.util.List;

public interface MatchRepository extends JpaRepository<Matches, Integer> {
    List<Matches> findMatchByPlayer1(Users player);

    List<Matches> findMatchByPlayer2(Users player);

    Matches findMatchesByPlayer1AndPlayer2(Users player1, Users player2);

    List<Matches> findMatchesByPlayer1OrPlayer2(Users player1, Users player2);

    Matches findMatchesByDate(LocalDate date);

    Matches findMatchesByPlayer1AndPlayer2AndDate(Users player1, Users player2, LocalDate date);

    Matches findMatchesByPlayer1AndDate(Users player1, LocalDate date);

    Matches findMatchesByPlayer2AndDate(Users player2, LocalDate date);

}
