package za.co.agentofcode.codeforcode.service;


import org.springframework.stereotype.Service;
import za.co.agentofcode.codeforcode.model.Matches;
import za.co.agentofcode.codeforcode.model.Users;
import za.co.agentofcode.codeforcode.repository.MatchRepository;
import za.co.agentofcode.codeforcode.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {
    private MatchRepository matchRepository;
    private UserRepository userRepository;

    private ArrayList<Users> queue = new ArrayList<>();

    public MatchService(MatchRepository matchRepository, UserRepository userRepository) {
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
    }

    public void createMatch(Matches match) {
        matchRepository.save(match);
    }

    public Matches getMatchByDate(LocalDate date) {
        return  matchRepository.findMatchesByDate(date);
    }

    public List<Matches> getAllMatchesByUser(Users user) {
        return matchRepository.findMatchesByPlayer1OrPlayer2(user, user);
    }

    public Matches getMatchByUsersAndDate(Users player1, Users player2, LocalDate date) {
        return matchRepository.findMatchesByPlayer1AndPlayer2AndDate(player1, player2, date);
    }

    public Matches addToQueue(String userName) {
        queue.add(userRepository.findByUserName(userName));
        return null;
    }
}
