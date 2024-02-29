package com.example.quiz.endpoint;

import com.example.quiz.dto.userDto.UserAuthDto;
import com.example.quiz.dto.userDto.UserDto;
import com.example.quiz.dto.userDto.UserSaveDto;
import com.example.quiz.entity.User;
import com.example.quiz.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserEndpoint {

    private final UserService userService;

    @PostMapping("/users/auth")
    @Operation(summary = "for authentication")
    public ResponseEntity<?> auth(@RequestBody UserAuthDto userAuthDto) {
        return ResponseEntity.ok(userService.authenticateUser(userAuthDto));
    }

    @GetMapping("/users")
    @Operation(summary = "finding all users")
    public List<UserDto> users() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    @Operation(summary = "find user by user id")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }


    @PostMapping("/users")
    @Operation(summary = "user creation")
    public UserDto user(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/users/{id}")
    @Operation(summary = "delete user by user id")
    public ResponseEntity<UserDto> deleteById(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PutMapping("/users/{id}")
    @Operation(summary = "for changing user email and password")
    public ResponseEntity<UserDto> user(@PathVariable("id") int id, @RequestBody UserSaveDto user) {
        return userService.updateUser(id, user);
    }

}
