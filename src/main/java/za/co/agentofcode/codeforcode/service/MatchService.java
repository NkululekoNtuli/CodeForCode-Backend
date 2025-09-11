package za.co.agentofcode.codeforcode.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.co.agentofcode.codeforcode.repository.MatchRepository;

@Service
public class MatchService {
    private MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }
}
