package za.co.agentofcode.codeforcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.agentofcode.codeforcode.model.Challenges;
import za.co.agentofcode.codeforcode.model.Users;
import za.co.agentofcode.codeforcode.service.ChallengeService;
import za.co.agentofcode.codeforcode.service.UserService;

import java.util.List;

@RestController
public class LeaderBoardController {
    private UserService userService;
    private ChallengeService challengeService;

    public LeaderBoardController(UserService userService, ChallengeService challengeService) {
        this.challengeService = challengeService;
        this.userService = userService;
    }

    @RequestMapping("/leaderboard")
    public String leaderBoard() {
        List<Users> users = userService.getUsersByRating(0);
        return "leader is not you";
    }
}
