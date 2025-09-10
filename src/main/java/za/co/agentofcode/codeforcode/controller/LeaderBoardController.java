package za.co.agentofcode.codeforcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaderBoardController {
    private LeaderBoardController leaderBoardController;

    public LeaderBoardController() {}

    @RequestMapping("/leaderboard")
    public String leaderBoard() {
        return "leader is not you";
    }
}
