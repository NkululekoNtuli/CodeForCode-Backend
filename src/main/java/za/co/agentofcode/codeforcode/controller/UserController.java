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

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String user(@RequestBody Map<String, String> data){
        Users user = userService.getUserByName(data.get("name"));
        return user.toString();
    }

    @RequestMapping(value = "/user-registration", method = RequestMethod.POST)
    public String registerUser(@RequestBody Map<String, String> data) {
        userService.registerUser(data.get("name"), data.get("email"), data.get("password"));
        return userService.getUserByName(data.get("name")).toString();
    }
}
