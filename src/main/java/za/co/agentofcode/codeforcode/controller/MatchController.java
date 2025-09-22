package za.co.agentofcode.codeforcode.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.agentofcode.codeforcode.model.Challenges;
import za.co.agentofcode.codeforcode.model.Matches;
import za.co.agentofcode.codeforcode.model.Users;
import za.co.agentofcode.codeforcode.service.ChallengeService;
import za.co.agentofcode.codeforcode.service.MatchService;
import za.co.agentofcode.codeforcode.service.UserService;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class MatchController {
    private  MatchService matchService;
    private UserService userService;
    private ChallengeService challengeService;

    public MatchController(MatchService matchService ) {
        this.matchService = matchService;
    }

    @RequestMapping(value = "/match-making", method = RequestMethod.POST)
    public String match(@RequestBody Map<String, Object> data) {
        List<String> players = (List<String>) data.get("players");
        String player1Name = players.getFirst();
        String player2Name = players.get(1);
        String winnerName = players.get(2);
        String challName = data.get("challengeName").toString();
        Instant startTime = (Instant) data.get("startTime");
        Instant endTime = (Instant) data.get("endTime");
        String status = data.get("status").toString();
        LocalDate date = (LocalDate) data.get("date");

        Users player1 = userService.getUserByName(player1Name);
        Users player2 = userService.getUserByName(player2Name);
        Users winner = userService.getUserByName(winnerName);
        Challenges challenge = challengeService.getChallenge(challName);

        Matches match = new Matches(player1, player2, winner, challenge, startTime, endTime, status, date);
        matchService.createMatch(match);
        return matchService.getMatchByUsersAndDate(player1, player2, date).toString();
    }

    @RequestMapping(value = "/match-history", method = RequestMethod.POST)
    public List<Matches> MatchHistory(@RequestBody Map<String, Users> data) {
        Users user = data.get("user");
        return matchService.getAllMatchesByUser(user);
    }
}
