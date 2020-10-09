package com.example.springboot;


import com.example.springboot.model.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private List<User> Users = new ArrayList<User>();

    @GetMapping("/users")
    public List<User> GetUsers(){
        return this.Users;
    }

    @GetMapping("/users/{Id}")
    public User GetSingleUser(@PathVariable("Id") int UserID) throws InterruptedException {
        TimeUnit.SECONDS.sleep(120);
        return this.Users.get(UserID - 1);
    }

    @PostConstruct
    private void LoadUsers(){
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("Pragadeesh");
        user1.setLastName("Chandrasekaran");
        user1.setEmail("pragadeesh@gmail.com");
        this.Users.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setFirstName("Aparna");
        user2.setLastName("Pragadeesh");
        user2.setEmail("pragadeesh@gmail.com");
        this.Users.add(user2);
    }
}
