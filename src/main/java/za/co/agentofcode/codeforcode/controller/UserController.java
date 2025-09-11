package za.co.agentofcode.codeforcode.controller;

import org.springframework.web.bind.annotation.*;
import za.co.agentofcode.codeforcode.model.Users;
import za.co.agentofcode.codeforcode.service.UserService;

@RestController
public class UserController {

    private UserService userService;

    public UserController( UserService userService ) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public String user(@PathVariable String name){
        Users user = userService.getUserByName(name);
        return user.toString();
    }

    @RequestMapping(value = "/user-registration/{name}/{email}/{password}", method = RequestMethod.GET)
    public String registerUser(@PathVariable String name, @PathVariable String email, @PathVariable String password) {
        userService.registerUser(name, email, password);
        return user(name);
    }
}
