package za.co.agentofcode.codeforcode.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;

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
    private LocalDate date;

    public Matches(){}
    public Matches(Users player1, Users player2, Users winner, Challenges challenges, Instant startTime, Instant endTime, String status, LocalDate date) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
        this.challenges = challenges;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Matches{" +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", winner=" + winner +
                ", challenges=" + challenges +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
