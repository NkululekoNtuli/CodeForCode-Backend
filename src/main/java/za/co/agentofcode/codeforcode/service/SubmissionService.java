package za.co.agentofcode.codeforcode.service;


import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.agentofcode.codeforcode.model.Matches;
import za.co.agentofcode.codeforcode.model.Submissions;
import za.co.agentofcode.codeforcode.model.Users;
import za.co.agentofcode.codeforcode.repository.SubmissionRepository;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class SubmissionService {
    private SubmissionRepository submissionRepository;
    private Dotenv dotenv = Dotenv.load();

    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public void creatSubmission(Matches match, Users user, String lang, String code, boolean verdict, int runtimeMs,
                                int memoryKb, int ingenuity, int score, Instant subTime) {

        Submissions submission = new Submissions(match, user, lang, code, verdict, runtimeMs,
                memoryKb, ingenuity, score, subTime);
        submissionRepository.save(submission);
    }

//    public void valuateCode() {


    public String runCode(String language, String code, String input) {
        String Judge0URL = dotenv.get("Judge0_Base_URL");
        String Judge0API = dotenv.get("Judge0_Api");

        Map<String, Object> body = new HashMap<>();
        body.put("language_id", getLanguageId(language));
        body.put("source_code", code);
        body.put("stdin", input);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-RapidAPI-Key", Judge0API);
        headers.set("X-RapidAPI-Host", Judge0URL);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response =
                restTemplate.postForEntity(Judge0URL + Judge0API,
                        entity,
                        Object.class);

        return response.getBody().toString();
    }

    private int getLanguageId(String lang) {
        switch (lang) {
            case "python": return 71;
            case "java": return 62;
            case "cpp": return 54;
            default: return 71;
        }
    }

    // Example: call an API that expects x-api-key header
    public String getData() {
        RestTemplate restTemplate = new RestTemplate();
        String Judge0URL = dotenv.get("Judge0_Base_URL");
        String Judge0API = dotenv.get("Judge0_Api");

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", Judge0API); // or "Authorization", depending on the API
        // If the API wants JSON
        headers.set("Accept", "application/json");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(Judge0URL, HttpMethod.GET, requestEntity, String.class);

        return response.getBody();
    }
}
