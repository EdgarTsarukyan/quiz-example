package com.example.quiz.service;

import com.example.quiz.dto.answer.GetAnswerDto;
import com.example.quiz.dto.answer.SaveAnswerDto;
import com.example.quiz.entity.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnswerService {

    List<GetAnswerDto> getAllAnswers();

    SaveAnswerDto createQuiz(Answer answer);

}
