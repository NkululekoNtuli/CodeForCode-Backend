package za.co.agentofcode.codeforcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.agentofcode.codeforcode.service.UserService;

@RestController
public class UserController {

    private UserService userService;

    public UserController( UserService userService ) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public String user(){
        return "Hello user";
    }
}
