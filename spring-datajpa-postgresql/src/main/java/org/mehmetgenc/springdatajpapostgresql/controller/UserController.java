package org.mehmetgenc.springdatajpapostgresql.controller;

import lombok.RequiredArgsConstructor;
import org.mehmetgenc.springdatajpapostgresql.dto.UserDto;
import org.mehmetgenc.springdatajpapostgresql.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

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
