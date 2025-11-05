package za.co.agentofcode.codeforcode.service;

import org.springframework.stereotype.Service;
import za.co.agentofcode.codeforcode.model.Challenges;
import za.co.agentofcode.codeforcode.repository.ChallengeRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class ChallengeService {
    private ChallengeRepository challengeRepository;

    private static String python = "Python";
    private String java = "Java";
    private String javaScript = "JavaScript";
    private String html = "Html";

    private static String  beginner = "Beginner";
    private String  Intermediate = "Intermediate";


    private final Challenges[] challenges = {
            new Challenges(python,"Sum of two numbers", "Write a program that takes two integers as input and prints their sum.", "....", beginner),
            new Challenges(python,"Even or odd", "Determine if a number is even or odd", "....", beginner),
            new Challenges(python,"Find maximum", "Read three integers and print the largest one", "....", beginner),
            new Challenges(python,"Reverse a string", "Reverse the given string", "....", beginner),
            new Challenges(python,"Count vowels", "Count the number of vowels in a string", "....", beginner),
    };

    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
        saveChallenges();
    }

    public Challenges getChallenge(String name) {
        return challengeRepository.findChallengesByName(name);
     }


     public List<Challenges> getChallengeByLanAndDiff(String lang, String difficulty){
        return challengeRepository.findAllByLanguageAndDifficulty(lang, difficulty);
     }

    public void saveChallenges(){
        challengeRepository.saveAll(Arrays.asList(challenges));
    }
}
