package za.co.agentofcode.codeforcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.agentofcode.codeforcode.service.MatchService;

@RestController
public class MatchController {
    private  MatchService matchService;

    public MatchController(MatchService matchService ) {
        this.matchService = matchService;
    }

    @RequestMapping("/match-making")
    public String match() {
        return "matching";
    }
}
