package za.co.agentofcode.codeforcode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String userName;
    private String emailAddress;
    private String password; // remember to hash password in db
    private int rating;
}
