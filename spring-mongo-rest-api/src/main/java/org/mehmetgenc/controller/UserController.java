package org.mehmetgenc.controller;

import jakarta.annotation.PostConstruct;
import org.mehmetgenc.entity.User;
import org.mehmetgenc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        User user = new User();
        user.setName("Mehmet");
        user.setSurname("Genc");
        user.setEmail("aa@a");
        user.setPassword("123");
        userRepository.save(user);
    }
    @PostMapping("/addUser")
    public ResponseEntity<User> AddUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }
    @GetMapping("/listUsers")
    public ResponseEntity<List<User>> ListUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
