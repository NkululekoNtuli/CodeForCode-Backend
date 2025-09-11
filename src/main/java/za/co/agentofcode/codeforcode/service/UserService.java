package za.co.agentofcode.codeforcode.service;

import org.springframework.stereotype.Service;
import za.co.agentofcode.codeforcode.model.Users;
import za.co.agentofcode.codeforcode.repository.UserRepository;

import java.time.Instant;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Users getUserByName(String userName) {
        List<Users> users = userRepository.findByUserName(userName);
        return users.getFirst();
    }

    public void registerUser(String name, String email, String password) {
        Users user = new Users(name, email, password, 0, Instant.now());
        userRepository.save(user);
    }

    public void updateRating(int addition, String name) {
        Users user = userRepository.findByUserName(name).getFirst();
        user.setRating(addition);
        userRepository.save(user);
    }
}
