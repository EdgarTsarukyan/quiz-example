package com.example.quiz.dto.quizDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetQuizDto {

    private String title;
    private LocalDate created_date_time;


}
