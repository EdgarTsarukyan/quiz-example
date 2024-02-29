package com.example.quiz.service.impl;

import com.example.quiz.dto.userDto.UserAuthDto;
import com.example.quiz.dto.userDto.UserAuthResponseDto;
import com.example.quiz.dto.userDto.UserDto;
import com.example.quiz.dto.userDto.UserSaveDto;
import com.example.quiz.entity.User;
import com.example.quiz.exception.CustomNotFoundException;
import com.example.quiz.exception.UnauthorizedException;
import com.example.quiz.repository.UserRepository;
import com.example.quiz.service.UserService;
import com.example.quiz.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() {

        List<User> all = userRepository.findAll();
        return all.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<UserDto> getUserById(int id) {
        User byId = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(modelMapper.map(byId, UserDto.class));
    }

    @Override
    public UserDto createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return modelMapper.map(userRepository.save(user), UserDto.class);

    }

    @Override
    public void deleteUserById(int id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            throw new CustomNotFoundException("user in this id does not exist");
        }
        userRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<UserDto> updateUser(int id, UserSaveDto user) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            throw new CustomNotFoundException("user in this id does not exist");
        }
        User userFromDB = byId.get();
        userFromDB.setName(user.getName());
        userFromDB.setEmail(user.getEmail());
        User save = userRepository.save(userFromDB);
        return ResponseEntity
                .ok()
                .body(modelMapper.map(save, UserDto.class));
    }

    @Override
    public UserAuthResponseDto authenticateUser(UserAuthDto userAuthDto) throws UnauthorizedException {
        Optional<User> optionalUser = userRepository.findByEmail(userAuthDto.getEmail());
        if (optionalUser.isEmpty() || !passwordEncoder.matches(userAuthDto.getPassword(),
                optionalUser.get().getPassword())) {
            throw new UnauthorizedException("Invalid credentials");
        }

        User user = optionalUser.get();
        return UserAuthResponseDto.builder()
                .token(jwtTokenUtil.generateToken(user.getEmail()))
                .userDto(modelMapper.map(user, UserDto.class))
                .build();
    }
}
