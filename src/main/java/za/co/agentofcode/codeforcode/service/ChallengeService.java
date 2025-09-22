package za.co.agentofcode.codeforcode.service;

import org.springframework.stereotype.Service;
import za.co.agentofcode.codeforcode.model.Challenges;
import za.co.agentofcode.codeforcode.repository.ChallengeRepository;

@Service
public class ChallengeService {
    private ChallengeRepository challengeRepository;

    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }


     public Challenges getChallenge(String name) {
        return challengeRepository.findChallengesByName(name);
     }
}
