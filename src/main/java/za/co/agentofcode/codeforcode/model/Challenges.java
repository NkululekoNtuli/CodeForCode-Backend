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


    public Challenges(){}
    public Challenges(String language, String name, String description, String testCases, String difficulty) {
        this.language = language;
        this.name = name;
        this.description = description;
        this.testCases = testCases;
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Challenges{" +
                "language='" + language + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", testCases='" + testCases + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
