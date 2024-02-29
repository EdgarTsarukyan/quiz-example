package com.example.quiz.dto.questionDto;

import com.example.quiz.enams.QuestionType;
import com.example.quiz.entity.Quiz;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class QuestionDto {

    private QuestionType questionType;
    private String title;
    private int score;
    private Quiz quiz;

}
