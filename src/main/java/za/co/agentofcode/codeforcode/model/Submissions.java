package za.co.agentofcode.codeforcode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.Instant;

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
}
