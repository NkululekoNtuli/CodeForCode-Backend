package za.co.agentofcode.codeforcode.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import za.co.agentofcode.codeforcode.model.Challenges;
import za.co.agentofcode.codeforcode.model.Matches;
import za.co.agentofcode.codeforcode.model.Users;
import za.co.agentofcode.codeforcode.service.ChallengeService;
import za.co.agentofcode.codeforcode.service.MatchService;
import za.co.agentofcode.codeforcode.service.UserService;
import za.co.agentofcode.codeforcode.websocket.MatchSocketHandler;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // allow Vite dev server
public class MatchController {
    private  MatchService matchService;
    private UserService userService;
    private ChallengeService challengeService;
    private final MatchSocketHandler handler;

    public MatchController(MatchService matchService, MatchSocketHandler handler) {
        this.matchService = matchService;
        this.handler = handler;
    }

    @RequestMapping(value = "/match-making", method = RequestMethod.POST)
    public String match(@RequestBody Map<String, Object> data) {
        List<String> players = (List<String>) data.get("players");
        String player1Name = players.getFirst();
        String player2Name = players.get(1);
        String winnerName = players.get(2);
        String challengeName = data.get("challengeName").toString();
        Instant startTime = (Instant) data.get("startTime");
        Instant endTime = (Instant) data.get("endTime");
        String status = data.get("status").toString();
        LocalDate date = (LocalDate) data.get("date");

        Users player1 = userService.getUserByName(player1Name);
        Users player2 = userService.getUserByName(player2Name);
        Users winner = userService.getUserByName(winnerName);
        Challenges challenge = challengeService.getChallenge(challengeName);

        Matches match = new Matches(player1, player2, winner, challenge, startTime, endTime, status, date);
        matchService.createMatch(match);
        return matchService.getMatchByUsersAndDate(player1, player2, date).toString();
    }

    @RequestMapping(value = "/match-history", method = RequestMethod.POST)
    public List<Matches> MatchHistory(@RequestBody Map<String, Users> data) {
        Users user = data.get("user");
        return matchService.getAllMatchesByUser(user);
    }

    @GetMapping("/test/broadcast")
    public String send() {
        handler.broadcastToMatch("123", "Hello CodeForCode!");
        return "Message sent";
    }
}
