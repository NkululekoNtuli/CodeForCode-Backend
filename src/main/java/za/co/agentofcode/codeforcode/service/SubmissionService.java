package za.co.agentofcode.codeforcode.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import org.aspectj.apache.bcel.classfile.Module;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import za.co.agentofcode.codeforcode.model.Matches;
import za.co.agentofcode.codeforcode.model.Submissions;
import za.co.agentofcode.codeforcode.model.Users;
import za.co.agentofcode.codeforcode.repository.SubmissionRepository;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubmissionService {
    private SubmissionRepository submissionRepository;
    private UserService userService;
    private Dotenv dotenv = Dotenv.load();
    private String judge0URL = dotenv.get("Judge0_Base_URL");
    private String judge0API = dotenv.get("Judge0_Api");

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
