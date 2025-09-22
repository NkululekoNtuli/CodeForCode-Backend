package za.co.agentofcode.codeforcode.controller;

import org.springframework.web.bind.annotation.*;
import za.co.agentofcode.codeforcode.model.Users;
import za.co.agentofcode.codeforcode.service.UserService;

import java.util.Map;

@RestController
@SessionAttributes("name")
public class UserController {

    private UserService userService;

    public UserController( UserService userService ) {
        this.userService = userService;
    }

// Do not forget to hash the password  from the front and from BL to DB
    @RequestMapping(value = "/user-login", method = RequestMethod.POST)
    public String user(@RequestBody Map<String, String> data){
        String userEmail = data.get("email");
        String userPassword = data.get("password");

        if (userService.isValidUser(userEmail, userPassword)) {
            Users validUser = userService.getUserByEmail(userEmail);
            return "welcome back master " + validUser.getUserName();
        }else {
            return "Who are you?";
        }
    }

    @RequestMapping(value = "/user-registration", method = RequestMethod.POST)
    public String registerUser(@RequestBody Map<String, String> data) {
        userService.registerUser(data.get("name"), data.get("email"), data.get("password"));
        return userService.getUserByName(data.get("name")).toString();
    }
}
