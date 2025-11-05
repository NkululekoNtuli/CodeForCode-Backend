package za.co.agentofcode.codeforcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.co.agentofcode.codeforcode.model.Challenges;
import za.co.agentofcode.codeforcode.repository.ChallengeRepository;
import za.co.agentofcode.codeforcode.service.ChallengeService;

@SpringBootApplication
public class CodeForCodeApplication {

//    private static String python = "Python";
//    private String java = "Java";
//    private String javaScript = "JavaScript";
//    private String html = "Html";
//
//    private static String  beginner = "Beginner";
//    private String  Intermediate = "Intermediate";
//
//    private static ChallengeService challengeService = new ChallengeService();
//
//
//    private static final Challenges[] challenges = {
//            new Challenges(python,"Sum of two numbers", "Write a program that takes two integers as input and prints their sum.", "....", beginner),
//            new Challenges(python,"Even or odd", "Determine if a number is even or odd", "....", beginner),
//            new Challenges(python,"Find maximum", "Read three integers and print the largest one", "....", beginner),
//            new Challenges(python,"Reverse a string", "Reverse the given string", "....", beginner),
//            new Challenges(python,"Count vowels", "Count the number of vowels in a string", "....", beginner),
//    };
//
//    public static void setUp(){
//        challengeService.saveChallenges(challenges);
//    }

    public static void main(String[] args) {
        SpringApplication.run(CodeForCodeApplication.class, args);
    }
}

