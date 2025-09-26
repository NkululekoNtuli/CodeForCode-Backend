package za.co.agentofcode.codeforcode.service;

import org.springframework.stereotype.Service;
import za.co.agentofcode.codeforcode.model.Matches;
import za.co.agentofcode.codeforcode.model.Submissions;
import za.co.agentofcode.codeforcode.model.Users;
import za.co.agentofcode.codeforcode.repository.SubmissionRepository;

import java.time.Instant;
import java.util.List;

@Service
public class SubmissionService {
    private SubmissionRepository submissionRepository;
    private UserService userService;

    public SubmissionService(SubmissionRepository submissionRepository, UserService userService) {
        this.submissionRepository = submissionRepository;
        this.userService = userService;

    }

    public void creatSubmission(Matches match, Users user, String lang, String code, boolean verdict, int runtimeMs,
                                int memoryKb, int ingenuity, int score, Instant subTime) {

        Submissions submission = new Submissions(match, user, lang, code, verdict, runtimeMs,
                memoryKb, ingenuity, score, subTime);

        submissionRepository.save(submission);
    }

    public List<Submissions>  getSubmissionsByUser(String userName) {
        Users user = userService.getUserByName(userName);
        return submissionRepository.findSubmissionsByUsers(user);
    }
}
