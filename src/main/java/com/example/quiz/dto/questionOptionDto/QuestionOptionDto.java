package com.example.quiz.dto.questionOptionDto;

import com.example.quiz.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class QuestionOptionDto {

    private Question question;
    private String title;
    private boolean isCorrect;

}
