package org.mehmetgenc.springdatajpapostgresql.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.mehmetgenc.springdatajpapostgresql.dto.UserDto;
import org.mehmetgenc.springdatajpapostgresql.entity.User;
import org.mehmetgenc.springdatajpapostgresql.repo.UserRepository;
import org.mehmetgenc.springdatajpapostgresql.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

}
