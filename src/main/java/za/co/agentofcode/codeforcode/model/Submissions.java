package za.co.agentofcode.codeforcode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;

@Entity
public class Submissions {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private Matches matches;
    @ManyToOne
    private Users users;
    private String language;
    private String code;
    private boolean verdict;
    private int runtimeMs;
    private int memoryKb;
    private int ingenuity;
    private int score;
    private Instant submissionTime;

    public Submissions(){};

    public Submissions(Matches matches, Users users, String language, String code, boolean verdict, int runtimeMs, int memoryKb, int ingenuity, int score, Instant submissionTime) {
        this.matches = matches;
        this.users = users;
        this.language = language;
        this.code = code;
        this.verdict = verdict;
        this.runtimeMs = runtimeMs;
        this.memoryKb = memoryKb;
        this.ingenuity = ingenuity;
        this.score = score;
        this.submissionTime = submissionTime;
    }
}
