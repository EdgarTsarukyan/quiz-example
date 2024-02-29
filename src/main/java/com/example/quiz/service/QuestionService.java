package com.example.quiz.service;

import com.example.quiz.dto.questionDto.QuestionDto;
import com.example.quiz.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {

    List<QuestionDto> getAllQuestions();

    QuestionDto createQuestion(Question question);

}
