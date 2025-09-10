package za.co.agentofcode.codeforcode.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Match {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private User player1, player2, winner;
    @ManyToOne
    private Challenge challenge;
    private Instant startTime, endTime;
    private String status;
}
