package EricSpencer00.Chat.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import EricSpencer00.Chat.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import EricSpencer00.Chat.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public User createUser(@RequestParam String username) {
        return userRepository.save(new User(null, username, null));
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
