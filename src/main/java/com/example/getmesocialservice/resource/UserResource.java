package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getuser(){

        return userService.getUser();
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user)
    {
        return userService.saveUser(user);

    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")

    public User getUserById(@PathVariable int userId)
    {
        return userService.getUserById(userId);
    }


}
