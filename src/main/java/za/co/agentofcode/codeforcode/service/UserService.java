package za.co.agentofcode.codeforcode.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.agentofcode.codeforcode.model.Users;
import za.co.agentofcode.codeforcode.repository.UserRepository;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private UserRepository userRepository;
    private SubmissionService submissionService;
    private Dotenv dotenv = Dotenv.load();

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Users getUserByName(String userName) {
        List<Users> users = userRepository.findByUserName(userName);
        return users.getFirst();
    }

    public void registerUser(String name, String email, String password) {
        Users user = new Users(name, email, password, 0, Instant.now());
        String code = "print('Hello World')";
//        runCode("python", code, "");
        userRepository.save(user);
    }

    public boolean isValidUser(String userEmail, String userPassword) {
//        try{
//            return  true;
////            userRepository.findUsersByEmailAddressAndPassword(userEmail, userPassword);
//
//        } catch (RuntimeException e) {
//            return false;
//        }


        return userRepository.searchByEmailAddressAndPassword(userEmail, userPassword);
    }

    public Users getUserByEmail(String emailAddress) {
        return userRepository.findUsersByEmailAddress(emailAddress);
    }

    public List<Users> getUsersByRating(int rating) {
        if (rating < 0) {rating = 1;}

        return userRepository.findAllByRatingGreaterThan(rating);
    }

    public void updateRating(int addition, String name) {
        Users user = userRepository.findByUserName(name).getFirst();
        user.setRating(addition);
        userRepository.save(user);
    }

    public void updateUserName(String newUserName, String email) {
        Users user = userRepository.findUsersByEmailAddress(email);
        user.setUserName(newUserName);
        userRepository.save(user);
    }

    public String runCode(String language, String code, String input) {
        String Judge0URL = dotenv.get("Judge0_Base_URL"+"/");
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
}
