package za.co.agentofcode.codeforcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.agentofcode.codeforcode.model.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> findByUserName(String username);
}
