package za.co.agentofcode.codeforcode.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONObject;
import org.springframework.http.*;
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
public class SandBoxService {
    private Dotenv dotenv = Dotenv.load();
    private String judge0URL = dotenv.get("Judge0_Base_URL");
    private String judge0API = dotenv.get("Judge0_Api");


    public JSONObject executeCodeSubmission(String language, String code, String input) {
        Map<String, Object> body = new HashMap<>();
        body.put("language_id", getLanguageId(language));
        body.put("source_code", code);
        body.put("stdin", input);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-RapidAPI-Key", judge0API);
        headers.set("X-RapidAPI-Host", "judge0-ce.p.rapidapi.com");

        ObjectMapper mapper = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        String url = judge0URL + "/submissions?base64_encoded=false&wait=false";

        try {
            String jsonBody = mapper.writeValueAsString(body);

            HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

            ResponseEntity<String> response =
                    restTemplate.postForEntity(url, entity, String.class);

            return new JSONObject(response.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new JSONObject().put("error", "JSON processing failed");
        }
    }


    private int getLanguageId(String lang) {
        switch (lang.toLowerCase()) {
            case "python": return 71;
            case "java": return 62;
            default: return 71;
        }
    }


    public JSONObject getData(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-RapidAPI-Key", judge0API);
        headers.set("X-RapidAPI-Host", "judge0-ce.p.rapidapi.com");
        headers.set("Accept", "application/json");

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        String url = judge0URL + "/submissions/"+token+"?base64_encoded=false&wait=false";
        System.out.println("get sub url:"+ url);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );

        return new JSONObject(response.getBody());
    }
}
