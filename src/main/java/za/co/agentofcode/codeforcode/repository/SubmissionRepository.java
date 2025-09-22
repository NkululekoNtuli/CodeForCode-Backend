package za.co.agentofcode.codeforcode.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import za.co.agentofcode.codeforcode.model.Submissions;
import za.co.agentofcode.codeforcode.model.Users;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submissions, Integer> {
    List<Submissions> findSubmissionsByUsers_UserName(String users_userName);

    List<Submissions> findAllByCode(String code);

    List<Submissions> findAllByVerdict(boolean verdict);

    List<Submissions> findAllByScore(int score);
}
