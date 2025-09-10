package za.co.agentofcode.codeforcode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.apache.logging.log4j.CloseableThreadContext;

import java.time.Instant;

@Entity
public class Submission {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private Match match;
    @ManyToOne
    private User user;
    private String language;
    private String code;
    private boolean verdict;
    private int runtimeMs;
    private int memoryKb;
    private int ingenuity;
    private int score;
    private Instant submissionTime;
}
