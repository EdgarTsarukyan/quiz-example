package com.example.quiz.dto.userDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserAuthResponseDto {


    private String token;
    private UserDto userDto;

}
