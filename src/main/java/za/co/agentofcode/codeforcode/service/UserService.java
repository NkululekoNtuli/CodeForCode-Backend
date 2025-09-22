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


}
