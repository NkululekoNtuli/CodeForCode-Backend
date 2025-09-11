package za.co.agentofcode.codeforcode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Challenges {
    @Id @GeneratedValue
    private Long id;
    private String language;
    private String name;
    private String description;
    private String testCases;
    private String difficulty;
}
