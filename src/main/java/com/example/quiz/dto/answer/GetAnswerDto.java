package com.example.quiz.dto.answer;

import com.example.quiz.entity.Question;
import com.example.quiz.entity.QuestionOption;
import com.example.quiz.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetAnswerDto {

    private User user;
    private Question question;
    private QuestionOption questionOption;
    private Date date_time;

}
