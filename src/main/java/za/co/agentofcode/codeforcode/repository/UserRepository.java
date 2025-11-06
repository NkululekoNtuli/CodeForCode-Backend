package za.co.agentofcode.codeforcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.agentofcode.codeforcode.model.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUserName(String username);

    void findUsersByEmailAddressAndPassword(String email, String password);

    Users findUsersByEmailAddress(String emailAddress);

    List<Users> findAllByRatingGreaterThan(int minRating);

    List<Users> findAllByRatingLessThan(int minRating);

    List<Users> findUsersByRatingBetween(int minRating, int maxRating);

    boolean searchByEmailAddressAndPassword(String emailAddress, String password);

}
