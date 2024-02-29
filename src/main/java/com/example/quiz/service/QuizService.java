package com.example.quiz.service;

import com.example.quiz.dto.quizDto.GetQuizDto;
import com.example.quiz.dto.quizDto.SaveQuizDto;
import com.example.quiz.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {

    List<GetQuizDto> getAllQuizzes();

    SaveQuizDto createQuiz(Quiz quiz);

}
