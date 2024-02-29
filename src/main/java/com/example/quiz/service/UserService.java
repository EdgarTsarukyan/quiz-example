package com.example.quiz.service;

import com.example.quiz.dto.userDto.UserAuthDto;
import com.example.quiz.dto.userDto.UserAuthResponseDto;
import com.example.quiz.dto.userDto.UserDto;
import com.example.quiz.dto.userDto.UserSaveDto;
import com.example.quiz.entity.User;
import com.example.quiz.exception.UnauthorizedException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    ResponseEntity<UserDto> getUserById(int id);

    UserDto createUser(User user);

    void deleteUserById(int id);

    ResponseEntity<UserDto> updateUser(int id, UserSaveDto user);

    UserAuthResponseDto authenticateUser(UserAuthDto userAuthDto) throws UnauthorizedException;
}
