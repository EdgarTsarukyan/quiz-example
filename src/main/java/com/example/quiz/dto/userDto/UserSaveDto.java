package com.example.quiz.dto.userDto;


import com.example.quiz.enams.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserSaveDto {

    private UserType userType;
    private String name;
    private String surname;
    private String email;
    private String password;

}
