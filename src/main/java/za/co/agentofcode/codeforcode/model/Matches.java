package za.co.agentofcode.codeforcode.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Matches {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private Users player1, player2, winner;
    @ManyToOne
    private Challenges challenges;
    private Instant startTime, endTime;
    private String status;
}
